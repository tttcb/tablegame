package com.guiguohui.system.controller;

import com.guiguohui.system.common.Result;
import com.guiguohui.system.domain.dto.Order;
import com.guiguohui.system.domain.dto.OrderCommodity;
import com.guiguohui.system.service.NoticeService;
import com.guiguohui.system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/guiguohui/notice")
public class NoticeController {


    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result alreadly(@RequestParam("Id") Integer id) {
        return Result.success(noticeService.alreadly(id));
    }

    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    @ResponseBody
    public Result queryAll() {
        return Result.success(noticeService.queryAll());
    }

    @RequestMapping(value = "/queryById", method = RequestMethod.GET)
    @ResponseBody
    public Result queryById(@RequestParam("Id") Integer id) {
        return Result.success(noticeService.queryById(id));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@RequestParam("Id") Integer id) {
        return Result.success(noticeService.delete(id));
    }



}
