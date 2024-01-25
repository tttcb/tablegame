package com.guiguohui.system.service.impl;

import cn.hutool.db.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guiguohui.system.common.PageHelper;
import com.guiguohui.system.domain.dto.*;
import com.guiguohui.system.mapper.TagMapper;
import com.guiguohui.system.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.guiguohui.system.common.Parameter.COMMODITY_ACTIVE;
import static com.guiguohui.system.common.Parameter.ORDER_DELETE;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    public TagMapper tagMapper;

    @Override
    public String insert(String name) {
        Tag tag = Tag.builder()
                .name(name)
                .status(COMMODITY_ACTIVE)
                .build();
        Integer result = tagMapper.insert(tag);
        if (result.equals(1)) {
            return "新增标签成功";
        } else {
            return "新增标签失败";
        }

    }
    @Override
    public String update(Integer id,String name) {
        QueryWrapper<Tag> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        Integer result = tagMapper.update(Tag.builder().name(name).build(), queryWrapper);
        if (result.equals(1)) {
            return "更新标签成功";
        } else {
            return "更新标签失败";
        }
    }

    @Override
    public PageHelper<Tag> queryAll(Integer pageIndex, Integer pageSize) {
        QueryWrapper<Tag> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", COMMODITY_ACTIVE);
        List<Tag> data =  tagMapper.selectList(queryWrapper);
        PageHelper<Tag> result = new PageHelper<>(0,pageSize, pageIndex,data);
        result.init();
        return result;
    }

    @Override
    public String delete(Integer id) {
        QueryWrapper<Tag> queryWrapper = new QueryWrapper<>();
        if (id == null) {
            return "ID不能为空";
        }
        queryWrapper.eq("Id", id);
        if (tagMapper.selectById(id) == null) {
            return "类型不存在";
        }
        if (Objects.equals(tagMapper.selectById(id).getStatus(), ORDER_DELETE)) {
            return "类型已经被删除";
        }
        tagMapper.update(Tag.builder()
                .status(ORDER_DELETE)
                .build(), queryWrapper);
        return "删除类型成功";
    }



}
