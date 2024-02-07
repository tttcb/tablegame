package com.guiguohui.system.service;

import com.guiguohui.system.common.PageHelper;
import com.guiguohui.system.domain.UserDetails;
import com.guiguohui.system.domain.dto.Address;
import com.guiguohui.system.domain.dto.User;
import org.springframework.web.bind.annotation.RequestParam;

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

    PageHelper<User> queryAll(String username,String role, Integer pageIndex, Integer pageSize);

    String resetPassWord(Integer userId, String password);

    String share();

    String updateAddress(Address address);

    PageHelper<Address> queryAddress(Integer userId, Integer id,Integer pageIndex,Integer pageSize);

    String addAddress(Address address);

    String deleteAddress(Integer addressId);
}
