package com.guiguohui.system.service.impl;

import com.guiguohui.system.domain.dto.Tag;
import com.guiguohui.system.mapper.TagMapper;
import com.guiguohui.system.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    public TagMapper tagMapper;

    @Override
    public Integer insert(String name) {
        Tag tag = Tag.builder()
                .name(name)
                .build();
        return tagMapper.insert(tag);

    }

}
