package com.guiguohui.system.controller;

import com.guiguohui.system.domain.dto.Criticize;
import com.guiguohui.system.service.CriticizeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/guiguohui/criticize")
@Api(tags = "评论相关接口")
public class CriticizeController {

    @Autowired
    public CriticizeService criticizeService;


    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("查询所有评论")
    public List<Criticize> queryAll(Integer commodityId) {
        return criticizeService.queryAll(commodityId);
    }

    @RequestMapping(value = "/queryById", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("根据评论ID查询")
    public List<Criticize> queryById(Integer criticizeId) {
        return criticizeService.queryById(criticizeId);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("新增评论")
    public String insert(@RequestBody String content) {
        return criticizeService.insert(content);
    }

    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("回复评论")
    public String reply(@RequestParam String content,@RequestParam("criticizeId") Integer criticizeId) {
        return criticizeService.reply(content,criticizeId);
    }


    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation("修改评论")
    public String update(@RequestParam String content,@RequestParam("criticizeId") Integer criticizeId) {
        return criticizeService.update(content,criticizeId);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation("删除评论")
    public String delete(@RequestParam("Id") Integer id) {
        return criticizeService.delete(id);
    }
}
