package com.guiguohui.system.controller;

import com.guiguohui.system.domain.dto.Message;
import com.guiguohui.system.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/guiguohui/message")
@Api(tags = "留言相关接口")
public class MessageController {

    @Autowired
    public MessageService messageService;


    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("查询所有留言")
    public List<Message> queryAll(Integer shopId) {
        return messageService.queryAll(shopId);
    }

    @RequestMapping(value = "/queryById", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("根据ID查询留言")
    public List<Message> queryById(Integer messageId) {
        return messageService.queryById(messageId);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("新增留言")
    public String insert(@RequestParam String content,@RequestParam("商铺id")Integer shopId) {
        return messageService.insert(content,shopId);
    }

    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("回复留言")
    public String reply(@RequestParam String content,@RequestParam("messageId") Integer messageId) {
        return messageService.reply(content,messageId);
    }


    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation("修改留言")
    public String update(@RequestParam String content,@RequestParam("messageId") Integer messageId) {
        return messageService.update(content,messageId);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation("删除留言")
    public String delete(@RequestParam("Id") Integer id) {
        return messageService.delete(id);
    }
}
