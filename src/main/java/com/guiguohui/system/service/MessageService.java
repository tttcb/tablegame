package com.guiguohui.system.service;

import com.guiguohui.system.domain.dto.Message;

import java.util.List;

public interface MessageService {
    List<Message> queryAll(Integer shopId);

    String insert(String content,Integer shopId);

    String update(String content,Integer messageId);

    String delete(Integer id);

    String reply(String content,Integer messageId);

    List<Message> queryById(Integer messageId) ;
}
