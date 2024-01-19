package com.guiguohui.system.controller;

import com.guiguohui.system.domain.dto.Notice;
import com.guiguohui.system.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/guiguohui/notice")
@Api(tags = "通知相关接口")
public class NoticeController {


    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/alreadly", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation("已读")
    public String alreadly(@RequestParam("Id") Integer id) {
        return noticeService.alreadly(id);
    }

    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("查询所有通知")
    public List<Notice> queryAll() {
        return noticeService.queryAll();
    }

    @RequestMapping(value = "/queryById", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("根据Id查询通知")
    public Notice queryById(@RequestParam("Id") Integer id) {
        return noticeService.queryById(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation("删除通知")
    public String delete(@RequestParam("Id") Integer id) {
        return noticeService.delete(id);
    }
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("新增通知")
    public String insert(@Validated @RequestBody Notice notice) {
        return noticeService.insert(notice);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation("修改通知")
    public String update(@Validated @RequestBody Notice notice) {
        return noticeService.update(notice);
    }



}
