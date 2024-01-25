package com.guiguohui.system.controller;

import com.guiguohui.system.common.PageHelper;
import com.guiguohui.system.domain.dto.User;
import com.guiguohui.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @ApiOperation("根据用户ID查询用户详情")
    public User queryByUserId(@RequestParam(value = "userId") Integer userId) {
        return userService.queryByUserId(userId);
    }

    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("查询所有用户")
    public PageHelper<User> queryAll(@RequestParam(value = "username", required = false) String username,
                                     @RequestParam(value = "pageIndex") Integer pageIndex,
                                     @RequestParam(value = "pageSize") Integer pageSize) {
        return userService.queryAll(username, pageIndex, pageSize);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation("删除用户")
    public String delete(@RequestParam(value = "userId") Integer userId) {
        return userService.delete(userId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("新增用户")
    public String add(User user) {
        return userService.add(user);
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("修改用户信息")
    public String modify(User user) {
        return userService.modify(user);
    }


    @RequestMapping(value = "/resetPassWord", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("重置密码")
    public String resetPassWord(@RequestParam(value = "userId") Integer userId, @RequestParam(value = "password") String password) {
        return userService.resetPassWord(userId, password);
    }

    @RequestMapping(value = "/share", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("分享")
    public String share() {
        return userService.share();
    }

}
