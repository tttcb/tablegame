package com.guiguohui.system.service;

import com.guiguohui.system.common.PageHelper;
import com.guiguohui.system.domain.dto.Callback;

import java.util.List;

public interface CallBackService {
    PageHelper<Callback> queryAll(Integer pageIndex, Integer pageSize);

    String insert(String content);

    String update(String content,Integer id);

    String delete(Integer id);
}
