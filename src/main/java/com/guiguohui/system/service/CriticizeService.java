package com.guiguohui.system.service;

import com.guiguohui.system.domain.dto.Criticize;

import java.util.List;

public interface CriticizeService {
    List<Criticize> queryAll(Integer commodityId);

    String insert(String content);

    String update(String content,Integer criticizeId);

    String delete(Integer id);

    String reply(String content,Integer criticizeId);

   List<Criticize> queryById(Integer criticizeId) ;
}
