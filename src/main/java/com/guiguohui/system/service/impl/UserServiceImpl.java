package com.guiguohui.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.guiguohui.system.domain.UserDetails;
import com.guiguohui.system.domain.dto.User;
import com.guiguohui.system.mapper.UserMapper;
import com.guiguohui.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.guiguohui.system.common.Parameter.USER_ACTIVE;
import static com.guiguohui.system.common.Parameter.USER_DELETE;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    public UserMapper userMapper;

    @Override
    public User queryByUserId(Integer userId) {
        if(userId == null) {
            throw new RuntimeException( "用户ID不能为空");
        }
        User user = userMapper.selectById(userId);
        return User.builder()
                .username(user.getUsername())
                .address(user.getAddress())
                .id(user.getId())
                .phone(user.getPhone())
                .email(user.getEmail())
                .lastTime(user.getLastTime())
                .nickname(user.getNickname())
                .role(user.getRole())
                .status(user.getStatus())
                .build();
    }

    @Override
    public String delete(Integer userId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(userId == null) {
            return "用户ID不能为空";
        }
        queryWrapper.eq("Id", userId);
        if(userMapper.selectById(userId) == null){
            return "用户不存在";
        }
        if(Objects.equals(userMapper.selectById(userId).getStatus(), USER_DELETE)){
            return "用户已经被删除";
        }
        userMapper.update(User.builder()
                .status(USER_DELETE)
                .build(),queryWrapper);
        return "删除用户成功";
    }

    @Override
    public String add(User user) {
        Integer result = userMapper.insert(user);
        if(result.equals(1)) {
            return "新增用户成功";
        }else {
            return "新增用户失败";
        }
    }

    @Override
    public String modify(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Id", user.getId());
        queryWrapper.eq("status", USER_ACTIVE);
        if(userMapper.selectById(user.getId()) == null){
            return "用户不存在";
        }
        Integer result = userMapper.update(user,queryWrapper);
        if(result.equals(1)) {
            return "修改用户成功";
        }else {
            return "修改用户失败";
        }
    }
}
