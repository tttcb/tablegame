package com.guiguohui.system.service;

import com.guiguohui.system.domain.dto.Notice;
import com.guiguohui.system.domain.dto.Tag;

import java.util.List;

/**
 * @author tu.cb
 */
public interface TagService {

    String insert(String name);

    String delete(Integer id);

    String update(Integer id,String name);

    List<Tag> queryAll();

}
