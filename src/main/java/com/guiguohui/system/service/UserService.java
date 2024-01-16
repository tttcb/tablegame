package com.guiguohui.system.service;

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

    List<User> queryAll();

    String resetPassWord(Integer userId, String password);
}
