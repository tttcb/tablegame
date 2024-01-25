package com.guiguohui.system.service;

import com.guiguohui.system.common.PageHelper;
import com.guiguohui.system.domain.dto.Notice;
import com.guiguohui.system.domain.dto.Order;

import java.util.List;

public interface NoticeService {



    String delete(Integer id);

    String insert(Notice notice);

    String update(Notice notice);

    String alreadly(Integer id);

    PageHelper<Notice> queryAll(Integer pageIndex, Integer pageSize);

    Notice queryById(Integer id);
}
