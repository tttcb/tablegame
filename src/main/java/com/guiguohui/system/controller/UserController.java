package com.guiguohui.system.controller;

import com.guiguohui.system.domain.dto.User;
import com.guiguohui.system.service.UserService;
import com.guiguohui.system.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tu.cb
 */
@RequestMapping(value = "/guiguohui/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public Result queryByUserId(Integer userId){
        return Result.success(userService.queryByUserId(userId));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(Integer userId){
        return Result.success(userService.delete(userId));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result add(User user){
        return Result.success(userService.add(user));
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ResponseBody
    public Result modify (User user){
        return Result.success(userService.modify(user));
    }
}
