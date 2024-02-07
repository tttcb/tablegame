package com.guiguohui.system.service.impl;

import cn.hutool.db.Page;
import cn.hutool.json.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.guiguohui.system.common.PageHelper;
import com.guiguohui.system.domain.UserDetails;
import com.guiguohui.system.domain.dto.Address;
import com.guiguohui.system.domain.dto.Notice;
import com.guiguohui.system.domain.dto.Order;
import com.guiguohui.system.domain.dto.User;
import com.guiguohui.system.mapper.AddressMapper;
import com.guiguohui.system.mapper.UserMapper;
import com.guiguohui.system.service.NoticeService;
import com.guiguohui.system.service.OrderService;
import com.guiguohui.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

import static com.guiguohui.system.common.Parameter.*;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    public UserMapper userMapper;


    @Autowired
    public AddressMapper addressMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public OrderService orderService;

    @Autowired
    public NoticeService noticeService;


    @Override
    public User queryByUserId(Integer userId) {
        if (userId == null) {
            throw new RuntimeException("用户ID不能为空");
        }
        User user = userMapper.selectById(userId);
        return user;
    }

    @Override
    public String delete(Integer userId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (userId == null) {
            return "用户ID不能为空";
        }
        queryWrapper.eq("Id", userId);
        if (userMapper.selectById(userId) == null) {
            return "用户不存在";
        }
        if (Objects.equals(userMapper.selectById(userId).getStatus(), USER_DELETE)) {
            return "用户已经被删除";
        }
        userMapper.update(User.builder()
                .status(USER_DELETE)
                .build(), queryWrapper);
        return "删除用户成功";
    }

    @Override
    public String add(User user) {
        user.setStatus(USER_ACTIVE);
        user.setLastTime(null);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Integer result = userMapper.insert(user);
        orderService.addGouWuChe(user.getId());
        noticeService.insert(Notice
                .builder()
                        .status(NOTICE_NEW)
                        .content(NOTICE_CONTENT_CUXIAO)
                        .userId(user.getId())
                        .type(NOTICE_CUXIAO)
                .build());
        if (result.equals(1)) {
            return "新增用户成功";
        } else {
            return "新增用户失败";
        }
    }

    @Override
    public String modify(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Id", user.getId());
        queryWrapper.eq("status", USER_ACTIVE);
        if (userMapper.selectById(user.getId()) == null) {
            return "用户不存在";
        }
        User user1 = user;
        Integer result = userMapper.update(user1, queryWrapper);
        if (result.equals(1)) {
            return "修改用户成功";
        } else {
            return "修改用户失败";
        }
    }

    @Override
    public PageHelper<User> queryAll(String username, String role,Integer pageIndex, Integer pageSize) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", USER_ACTIVE);
        if (username != null) {
            queryWrapper.eq("user_name", username);
        }
        if (role != null) {
            queryWrapper.eq("role", role);
        }
        List<User> data = userMapper.selectList(queryWrapper);
        int i = 0;
        for (User user : data) {
            data.set(i++, user);
        }
        PageHelper<User> result = new PageHelper<>(0, pageSize, pageIndex, data);
        result.init();
        return result;
    }

    @Override
    public String resetPassWord(Integer userId, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Id", userId);
        queryWrapper.eq("status", USER_ACTIVE);
        if (userMapper.selectById(userId) == null) {
            return "用户不存在";
        }
        Integer result = userMapper.update(User.builder().password(password).build(), queryWrapper);
        if (result.equals(1)) {
            return "修改用户密码成功";
        } else {
            return "修改用户密码失败";
        }
    }

    @Override
    public String share() {
        return "购买体验十分好!,快来桂果汇购买水果吧！www.guiguohui.com";
    }

    @Override
    public String updateAddress(Address address) {
        QueryWrapper<Address> query = new QueryWrapper<>();
        query.eq("status", COMMODITY_ACTIVE);
        query.eq("id",address.getId());
        Integer result = addressMapper.update(address, query);
        if (result.equals(1)) {
            return "修改用户成功";
        } else {
            return "修改用户失败";
        }
    }

    @Override
    public PageHelper<Address> queryAddress(Integer userId, Integer id,Integer pageIndex,Integer pageSize) {
        QueryWrapper<Address> query = new QueryWrapper<>();
        query.eq("status", COMMODITY_ACTIVE);
        if(userId!=null){
            query.eq("user_id",userId);
        }
        if(id!=null){
            query.eq("id",id);
        }
        List<Address> data =addressMapper.selectList(query);
        PageHelper<Address> result = new PageHelper<>(0, pageSize, pageIndex, data);
        result.init();
        return result;

    }

    @Override
    public String addAddress(Address address) {
        address.setStatus(COMMODITY_ACTIVE);
        addressMapper.insert(address);
        return "新增收货地址成功";

    }

    @Override
    public String deleteAddress(Integer addressId) {
        QueryWrapper<Address> queryWrapper = new QueryWrapper<>();
        if (addressId == null) {
            return "ID不能为空";
        }
        queryWrapper.eq("Id", addressId);
        if (addressMapper.selectById(addressId) == null) {
            return "地址Id不存在";
        }
        if (Objects.equals(addressMapper.selectById(addressId).getStatus(), COMMODITY_DELETE)) {
            return "地址已经被删除";
        }
        addressMapper.update(Address.builder()
                .status(COMMODITY_DELETE)
                .build(), queryWrapper);
        return "删除收货地址成功";
    }
}
