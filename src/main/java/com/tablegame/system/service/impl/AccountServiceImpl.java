package com.tablegame.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tablegame.system.config.SecurityContext;
import com.tablegame.system.domain.dto.Fund;
import com.tablegame.system.domain.UserDetail;
import com.tablegame.system.mapper.FundMapper;
import com.tablegame.system.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    private FundMapper fundMapper;

    @Override
    public UserDetail query() {
        QueryWrapper<Fund> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", SecurityContext.getUserId());
        List<Fund> lists = fundMapper.selectList(queryWrapper);
        return UserDetail.builder()
                        .username(SecurityContext.getUsername())
                        .fundGames(lists)
                        .password(SecurityContext.getPassword())
                        .build();
    }
}
