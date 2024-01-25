package com.guiguohui.system.controller;

import com.guiguohui.system.common.PageHelper;
import com.guiguohui.system.domain.dto.Callback;
import com.guiguohui.system.service.CallBackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/guiguohui/callback")
@Api(tags = "反馈相关接口")
public class CallBackController {

    @Autowired
    public CallBackService callBackService;


    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("查询所有反馈")
    public PageHelper<Callback> queryAll( @RequestParam(value = "pageIndex") Integer pageIndex,
                                          @RequestParam(value = "pageSize") Integer pageSize) {
        return callBackService.queryAll(pageIndex, pageSize);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("新增反馈")
    public String insert(@RequestParam("content") String content) {
        return callBackService.insert(content);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation("修改反馈")
    public String update(@RequestParam("content") String content,@RequestParam("Id") Integer id) {
        return callBackService.update(content,id);
    }
    @ApiOperation("删除反馈")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@RequestParam("Id") Integer id) {
        return callBackService.delete(id);
    }
}
