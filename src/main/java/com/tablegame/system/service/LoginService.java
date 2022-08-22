package com.tablegame.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tablegame.system.common.AdminUserDetails;
import com.tablegame.system.domain.User;
import com.tablegame.system.mapper.UserMapper;
import com.tablegame.system.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author tu.cb
 */
@Component
@Slf4j
public class LoginService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private RedisServer redisServer;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Value("${redis.redisPrefix}")
    private String redisPrefix;

    @Value("${jwt.expiration}")
    private Long expiration;
    @Resource
    private UserMapper userMapper;

    public UserDetails loadUserByUsername(String username) {
        // 根据用户名查询用户
        User admin = getAdminByUsername(username);
        if (admin != null) {
            return new AdminUserDetails(admin);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    public User getAdminByUsername(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", username);
        List<User> usersList = userMapper.selectList(queryWrapper);

        if (usersList != null && usersList.size() > 0) {
            return usersList.get(0);
        }
        // 用户名错误，提前抛出异常
        throw new UsernameNotFoundException("用户名错误");
    }


    public String refreshToken(String token) {
        String authToken = token.substring(this.tokenHead.length());
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!jwtTokenUtil.isTokenExpired(authToken)) {
            String newtoken = jwtTokenUtil.generateToken(loadUserByUsername(username));
            redisServer.setCacheObject(redisPrefix + username, newtoken, expiration, TimeUnit.SECONDS);
            return newtoken;
        }
        throw new RuntimeException("Could not refresh token");
    }

    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            // 查询用户+用户资源
            UserDetails userDetails = loadUserByUsername(username);
            // 验证密码
            System.out.println(passwordEncoder.encode(password));
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            // 返回 JWT
            token = jwtTokenUtil.generateToken(userDetails);
            redisServer.setCacheObject(redisPrefix + username, token, expiration, TimeUnit.SECONDS);
        } catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }
}
