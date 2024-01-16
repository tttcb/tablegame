package com.guiguohui.system.service;

import com.guiguohui.system.domain.dto.Commodity;
import com.guiguohui.system.domain.dto.Order;
import com.guiguohui.system.domain.dto.OrderCommodity;

import java.util.List;

public interface OrderService {


    List<Order> queryByUserId(Integer userId);

    String delete(Integer id);

    Order queryById(Integer id);

    String addCommodity(Integer id, Integer count);

    String insert(Order order);

    String update(Order order);

    String deleteCommodity(Integer id);

    List<OrderCommodity> queryGouWuChe(Integer userId);

    String updateGouWuChe(OrderCommodity orderCommodity);
}
