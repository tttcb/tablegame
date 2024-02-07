package com.guiguohui.system.service;

import com.guiguohui.system.common.PageHelper;
import com.guiguohui.system.domain.dto.Commodity;
import com.guiguohui.system.domain.dto.Order;
import com.guiguohui.system.domain.dto.OrderCommodity;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.List;

public interface OrderService {


    PageHelper<Order> queryByUserId(Integer userId,Integer status,Integer pageIndex, Integer pageSize);

    String delete(Integer id);

    Order queryById(Integer id);

    String addCommodity(Integer id, Integer count);

    String insert(Order order) throws ParseException;

    String update(Order order);

    String deleteCommodity(Integer id);

    List<OrderCommodity> queryGouWuChe(Integer userId);

    String updateGouWuChe(Integer orderCommodityId,Integer count);

    String updateGouWuCheAddress(Integer orderCommodityId,Integer addressId);

    Void addGouWuChe(Integer userId);
}
