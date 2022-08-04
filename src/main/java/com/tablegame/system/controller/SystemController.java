package com.tablegame.system.controller;

import com.tablegame.system.common.Result;
import com.tablegame.system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tu.cb
 */
@RestController
@RequestMapping("/system")
public class SystemController {

    @Autowired
    public LoginService loginService;

    @PostMapping("/login")
    public Result login(String username, String password){
        loginService.login(username, password);
        return Result.success(loginService.createToken(username, password));
    }
}
