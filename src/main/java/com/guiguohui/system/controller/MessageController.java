package com.guiguohui.system.controller;

import com.guiguohui.system.common.Result;
import com.guiguohui.system.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/guiguohui/message")
public class MessageController {

    @Autowired
    public MessageService messageService;


    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    @ResponseBody
    public Result queryAll() {
        return Result.success(messageService.queryAll());
    }

    @RequestMapping(value = "/queryById", method = RequestMethod.GET)
    @ResponseBody
    public Result queryById(Integer messageId) {
        return Result.success(messageService.queryById(messageId));
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(@RequestBody String content) {
        return Result.success(messageService.insert(content));
    }

    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    @ResponseBody
    public Result reply(@RequestBody String content,@RequestParam("messageId") Integer messageId) {
        return Result.success(messageService.reply(content,messageId));
    }


    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@RequestBody String content,@RequestParam("messageId") Integer messageId) {
        return Result.success(messageService.update(content,messageId));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@RequestParam("Id") Integer id) {
        return Result.success(messageService.delete(id));
    }
}
