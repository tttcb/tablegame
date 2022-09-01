package com.tablegame.system.service.impl;

import com.tablegame.system.domain.dto.Tag;
import com.tablegame.system.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tablegame.system.service.TagService;

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
