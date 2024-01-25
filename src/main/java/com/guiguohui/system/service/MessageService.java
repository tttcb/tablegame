package com.guiguohui.system.service;

import com.guiguohui.system.common.PageHelper;
import com.guiguohui.system.domain.dto.Message;

import java.util.List;

public interface MessageService {
    PageHelper<Message> queryAll(Integer shopId,Integer pageIndex, Integer pageSize);

    String insert(String content,Integer shopId);

    String update(String content,Integer messageId);

    String delete(Integer id);

    String reply(String content,Integer messageId);

    PageHelper<Message> queryById(Integer messageId,Integer pageIndex, Integer pageSize) ;
}
