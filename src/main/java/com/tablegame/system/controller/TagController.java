package com.tablegame.system.controller;

import com.tablegame.system.common.Result;
import com.tablegame.system.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tablegames/tag")
public class TagController {

    @Autowired
    public TagService tagService;


    @ResponseBody
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Result insert(String name){
        return Result.success(tagService.insert(name));
    }
}
