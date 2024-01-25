package com.guiguohui.system.controller;

import com.guiguohui.system.common.PageHelper;
import com.guiguohui.system.domain.dto.Tag;
import com.guiguohui.system.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/guiguohui/tag")
@Api(tags = "标签相关接口")
public class TagController {

    @Autowired
    public TagService tagService;


    @ResponseBody
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation("新增标签")
    public String insert(@RequestParam("name") String name){
        return tagService.insert(name);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation("更新标签信息")
    public String update(@RequestParam("Id") Integer id,@RequestParam("name") String name) {
        return tagService.update(id,name);
    }

    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("查询所有标签")
    public PageHelper<Tag> queryAll(@RequestParam(value = "pageIndex") Integer pageIndex,
                                    @RequestParam(value = "pageSize") Integer pageSize) {
        return tagService.queryAll(pageIndex,pageSize);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation("删除标签")
    public String delete(@RequestParam("Id") Integer id) {
        return tagService.delete(id);
    }

}
