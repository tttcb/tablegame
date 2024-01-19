package com.guiguohui.system.controller;

import com.guiguohui.system.common.Result;
import com.guiguohui.system.domain.dto.Callback;
import com.guiguohui.system.domain.dto.Commodity;
import com.guiguohui.system.service.CallBackService;
import com.guiguohui.system.service.TagService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/guiguohui/callback")
@Api(tags = "反馈相关接口")
public class CallBackController {

    @Autowired
    public CallBackService callBackService;


    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    @ResponseBody
    public Result queryAll() {
        return Result.success(callBackService.queryAll());
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(@RequestBody Callback callback) {
        return Result.success(callBackService.insert(callback));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@RequestBody Callback callback) {
        return Result.success(callBackService.update(callback));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@RequestParam("Id") Integer id) {
        return Result.success(callBackService.delete(id));
    }
}
