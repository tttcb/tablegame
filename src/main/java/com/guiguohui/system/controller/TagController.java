package com.guiguohui.system.controller;

import com.guiguohui.system.common.Result;
import com.guiguohui.system.service.TagService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/guiguohui/tag")
@Api(tags = "标签相关接口")
public class TagController {

    @Autowired
    public TagService tagService;


    @ResponseBody
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Result insert(@RequestParam("name") String name){
        return Result.success(tagService.insert(name));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@RequestParam("Id") Integer id,@RequestParam("name") String name) {
        return Result.success(tagService.update(id,name));
    }

    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    @ResponseBody
    public Result queryAll() {
        return Result.success(tagService.queryAll());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@RequestParam("Id") Integer id) {
        return Result.success(tagService.delete(id));
    }

}
