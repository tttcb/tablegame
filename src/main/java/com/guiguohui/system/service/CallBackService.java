package com.guiguohui.system.service;

import com.guiguohui.system.domain.dto.Callback;

import java.util.List;

public interface CallBackService {
    List<Callback> queryAll();

    String insert(Callback callback);

    String update(Callback callback);

    String delete(Integer id);
}
