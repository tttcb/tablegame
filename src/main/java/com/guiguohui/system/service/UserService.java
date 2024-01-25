package com.guiguohui.system.service;

import com.guiguohui.system.common.PageHelper;
import com.guiguohui.system.domain.UserDetails;
import com.guiguohui.system.domain.dto.User;

import java.util.List;

/**
 * @author tu.cb
 */
public interface UserService {

    /**
     * 查询账号
     * @return
     */
    User queryByUserId(Integer userId);

    String delete(Integer userId);

    String add(User user);

    String modify(User user);

    PageHelper<User> queryAll(String username, Integer pageIndex, Integer pageSize);

    String resetPassWord(Integer userId, String password);

    String share();
}
