package com.guiguohui.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guiguohui.system.config.SecurityContext;
import com.guiguohui.system.domain.dto.Message;
import com.guiguohui.system.mapper.MessageMapper;
import com.guiguohui.system.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.guiguohui.system.common.Parameter.COMMODITY_ACTIVE;
import static com.guiguohui.system.common.Parameter.COMMODITY_DELETE;

/**
 * @author tu.cb
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;


    @Override
    public List<Message> queryAll() {
        QueryWrapper<Message> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", COMMODITY_ACTIVE);
        queryWrapper.eq("message_id",null);
        return messageMapper.selectList(queryWrapper);
    }

    @Override
    public List<Message> queryById(Integer messageId) {
        QueryWrapper<Message> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", messageId).or().eq("message_id",messageId).orderByDesc("id");
        return messageMapper.selectList(queryWrapper);
    }



    @Override
    public String insert(String content) {
        Integer result = messageMapper.insert(Message.builder()
                        .content(content)
                        .userId(SecurityContext.getUserId())
                        .status(COMMODITY_ACTIVE)
                .build());
        if (result.equals(1)) {
            return "新增评价成功";
        } else {
            return "新增评价失败";
        }
    }

    @Override
    public String update(String content,Integer messageId) {
        QueryWrapper<Message> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", messageId);
        queryWrapper.eq("status", COMMODITY_ACTIVE);
        Integer result = messageMapper.update(Message.builder().content(content).build(), queryWrapper);
        if (result.equals(1)) {
            return "更新评价成功";
        } else {
            return "更新评价失败";
        }
    }

    @Override
    public String delete(Integer id) {
        QueryWrapper<Message> queryWrapper = new QueryWrapper<>();
        if (id == null) {
            return "评价ID不能为空";
        }
        queryWrapper.eq("Id", id);
        if (messageMapper.selectById(id) == null) {
            return "评价不存在";
        }
        if (Objects.equals(messageMapper.selectById(id).getStatus(), COMMODITY_DELETE)) {
            return "评价已经被删除";
        }
        messageMapper.update(Message.builder()
                .status(COMMODITY_DELETE)
                .build(), queryWrapper);
        return "删除评价成功";
    }

    @Override
    public String reply(String content,Integer messageId) {
        Integer result = messageMapper.insert(Message.builder()
                .content(content)
                .userId(SecurityContext.getUserId())
                .messageId(messageId)
                .status(COMMODITY_ACTIVE)
                .build());
        if (result.equals(1)) {
            return "新增评价成功";
        } else {
            return "新增评价失败";
        }
    }

}
