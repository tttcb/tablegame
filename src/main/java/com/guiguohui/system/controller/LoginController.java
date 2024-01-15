package com.guiguohui.system.controller;

import com.guiguohui.system.common.Result;
import com.guiguohui.system.domain.dto.User;
import com.guiguohui.system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/guiguohui")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(@Validated @RequestBody User users, BindingResult result) {
        String token = loginService.login(users.getUsername(), users.getPassword());
        if (token == null) {
            return Result.error("用户名或密码错误");
        }
        // 将 JWT 传递回客户端
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return Result.success("操作成功",tokenMap);
    }

    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
    @ResponseBody
    public Result refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = loginService.refreshToken(token);
        if (refreshToken == null) {
            return Result.error("token已经过期！");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return Result.success("操作成功",tokenMap);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public Result test() {
       return Result.success("success");
    }

}
