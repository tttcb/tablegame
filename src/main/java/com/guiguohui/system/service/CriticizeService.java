package com.guiguohui.system.service;

import com.guiguohui.system.common.PageHelper;
import com.guiguohui.system.domain.dto.Criticize;

import java.util.List;

public interface CriticizeService {
    PageHelper<Criticize> queryAll(Integer orderId,Integer pageIndex, Integer pageSize);

    String insert(String content,Integer orderId);

    String update(String content,Integer criticizeId);

    String delete(Integer id);

    String reply(String content,Integer criticizeId);

   List<Criticize> queryById(Integer criticizeId) ;
}
