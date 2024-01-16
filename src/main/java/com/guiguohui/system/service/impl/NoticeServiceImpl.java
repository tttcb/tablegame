package com.guiguohui.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guiguohui.system.config.SecurityContext;
import com.guiguohui.system.domain.dto.Notice;
import com.guiguohui.system.domain.dto.Order;
import com.guiguohui.system.mapper.NoticeMapper;
import com.guiguohui.system.mapper.OrderMapper;
import com.guiguohui.system.service.NoticeService;
import com.guiguohui.system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.guiguohui.system.common.Parameter.*;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    public NoticeMapper noticeMapper;

    @Override
    public String insert(Notice notice) {
        Integer result = noticeMapper.insert(notice);
        if (result.equals(1)) {
            return "新增通知成功";
        } else {
            return "新增通知失败";
        }
    }

    @Override
    public String update(Notice notice) {
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", notice.getId());
        Integer result = noticeMapper.update(notice, queryWrapper);
        if (result.equals(1)) {
            return "更新通知成功";
        } else {
            return "更新通知失败";
        }
    }

    @Override
    public String alreadly(Integer id) {
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        Integer result = noticeMapper.update(Notice.builder()
                .status(NOTICE_ALREADLY)
                .build(), queryWrapper);
        if (result.equals(1)) {
            return "更新通知成功";
        } else {
            return "更新通知失败";
        }
    }

    @Override
    public List<Notice> queryAll() {
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", SecurityContext.getUserId());
        queryWrapper.ne("status", NOTICE_DELETE);
        return noticeMapper.selectList(queryWrapper);
    }

    @Override
    public Notice queryById(Integer id) {
        return noticeMapper.selectById(id);
    }

    @Override
    public String delete(Integer id) {
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        if (id == null) {
            return "通知ID不能为空";
        }
        queryWrapper.eq("Id", id);
        if (noticeMapper.selectById(id) == null) {
            return "通知不存在";
        }
        if (Objects.equals(noticeMapper.selectById(id).getStatus(), NOTICE_DELETE)) {
            return "通知已经被删除";
        }
        noticeMapper.update(Notice.builder()
                .status(NOTICE_DELETE)
                .build(), queryWrapper);
        return "删除通知成功";
    }

}
