package com.guiguohui.system.controller;

import com.guiguohui.system.common.Result;
import com.guiguohui.system.domain.dto.Callback;
import com.guiguohui.system.domain.dto.Criticize;
import com.guiguohui.system.service.CallBackService;
import com.guiguohui.system.service.CriticizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/guiguohui/criticize")
public class CriticizeController {

    @Autowired
    public CriticizeService criticizeService;


    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    @ResponseBody
    public Result queryAll() {
        return Result.success(criticizeService.queryAll());
    }

    @RequestMapping(value = "/queryById", method = RequestMethod.GET)
    @ResponseBody
    public Result queryById(Integer criticizeId) {
        return Result.success(criticizeService.queryById(criticizeId));
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(@RequestBody String content) {
        return Result.success(criticizeService.insert(content));
    }

    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    @ResponseBody
    public Result reply(@RequestBody String content,@RequestParam("criticizeId") Integer criticizeId) {
        return Result.success(criticizeService.reply(content,criticizeId));
    }


    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@RequestBody String content,@RequestParam("criticizeId") Integer criticizeId) {
        return Result.success(criticizeService.update(content,criticizeId));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@RequestParam("Id") Integer id) {
        return Result.success(criticizeService.delete(id));
    }
}
