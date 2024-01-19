package com.guiguohui.system.controller;

import com.guiguohui.system.domain.dto.User;
import com.guiguohui.system.service.UserService;
import com.guiguohui.system.common.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

/**
 * @author tu.cb
 */
@RequestMapping(value = "/guiguohui/user")
@RestController
@Api(tags = "用户相关接口")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/queryByUserId", method = RequestMethod.GET)
    @ResponseBody
    public Result queryByUserId(@RequestParam(value = "userId") Integer userId){
        return Result.success(userService.queryByUserId(userId));
    }
    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    @ResponseBody
    public Result queryAll(){
        return Result.success(userService.queryAll());
    }
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@RequestParam(value = "userId") Integer userId){
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


    @RequestMapping(value = "/resetPassWord", method = RequestMethod.POST)
    @ResponseBody
    public Result resetPassWord (@RequestParam(value = "userId") Integer userId, @RequestParam(value = "password") String password){
        return Result.success(userService.resetPassWord(userId,password));
    }
    @RequestMapping(value = "/share", method = RequestMethod.POST)
    @ResponseBody
    public Result share (){
        return Result.success(userService.share());
    }

}
