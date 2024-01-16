package com.guiguohui.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guiguohui.system.config.SecurityContext;
import com.guiguohui.system.domain.dto.Commodity;
import com.guiguohui.system.domain.dto.Order;
import com.guiguohui.system.domain.dto.OrderCommodity;
import com.guiguohui.system.mapper.OrderCommodityMapper;
import com.guiguohui.system.mapper.OrderMapper;
import com.guiguohui.system.service.CommodityService;
import com.guiguohui.system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.guiguohui.system.common.Parameter.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    public OrderCommodityMapper orderCommodityMapper;

    @Autowired
    public OrderMapper orderMapper;

    @Autowired
    public CommodityService commodityService;

    @Override
    public String insert(Order order) {
        Integer result = orderMapper.insert(order);
        if (result.equals(1)) {
            return "新增订单成功";
        } else {
            return "新增订单失败";
        }
    }

    @Override
    public String update(Order order) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", order.getId());
        queryWrapper.eq("status", COMMODITY_ACTIVE);
        Integer result = orderMapper.update(order, queryWrapper);
        if (result.equals(1)) {
            return "更新订单成功";
        } else {
            return "更新订单失败";
        }
    }

    @Override
    public String deleteCommodity(Integer id) {
        QueryWrapper<OrderCommodity> queryWrapper = new QueryWrapper<>();
        if (id == null) {
            return "ID不能为空";
        }
        queryWrapper.eq("Id", id);
        if (orderCommodityMapper.selectById(id) == null) {
            return "购物车中不存在该商品";
        }
        if (Objects.equals(orderCommodityMapper.selectById(id).getStatus(), ORDERCOMMODITY_DELETE)) {
            return "购物车商品已被删除";
        }
        orderCommodityMapper.update(OrderCommodity.builder()
                .status(ORDERCOMMODITY_DELETE)
                .build(), queryWrapper);
        return "删除购物车商品成功";
    }

    @Override
    public List<OrderCommodity> queryGouWuChe(Integer userId) {
        if (userId != null) {
            QueryWrapper<OrderCommodity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("order_id",queryGouWuCheId(userId).getId());
            queryWrapper.eq("status",ORDERCOMMODITY_ACTIVE);
            return orderCommodityMapper.selectList(queryWrapper);
        } else {
            throw new IllegalArgumentException("id不能为空");
        }
    }

    @Override
    public String updateGouWuChe(OrderCommodity orderCommodity) {
        QueryWrapper<OrderCommodity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", orderCommodity.getId());
        queryWrapper.eq("status", COMMODITY_ACTIVE);
        Integer result = orderCommodityMapper.update(orderCommodity, queryWrapper);
        if (result.equals(1)) {
            return "更新购物车商品成功";
        } else {
            return "更新购物车商品失败";
        }
    }


    @Override
    public List<Order> queryByUserId(Integer userId) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        if (userId == null) {
            throw new IllegalArgumentException("用户ID不能为空");
        }
        queryWrapper.eq("userId", userId);
        return orderMapper.selectList(queryWrapper);
    }

    @Override
    public String delete(Integer id) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        if (id == null) {
            return "订单ID不能为空";
        }
        queryWrapper.eq("Id", id);
        if (orderMapper.selectById(id) == null) {
            return "订单不存在";
        }
        if (Objects.equals(orderMapper.selectById(id).getStatus(), ORDER_DELETE)) {
            return "订单已经被删除";
        }
        orderMapper.update(Order.builder()
                .status(ORDER_DELETE)
                .build(), queryWrapper);
        return "删除订单成功";
    }

    @Override
    public Order queryById(Integer id) {
        if (id != null) {
            return orderMapper.selectById(id);
        } else {
            throw new IllegalArgumentException("id不能为空");
        }
    }

    public Order queryGouWuCheId(Integer userId) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        queryWrapper.eq("status",ORDER_GOUWUCHE);
        if (userId != null) {
            return orderMapper.selectOne(queryWrapper);
        } else {
            throw new IllegalArgumentException("id不能为空");
        }
    }

    @Override
    public String addCommodity(Integer id, Integer count) {
        if (id != null) {
            Commodity commodity =commodityService.queryById(id);
            orderCommodityMapper.insert(
                    OrderCommodity.builder()
                            .orderId(queryGouWuCheId(SecurityContext.getUserId()).getId())
                            .price(commodity.getPrice())
                            .count(count)
                            .commodityId(id)
                            .name(commodity.getName())
                            .tag(commodity.getTag())
                            .build()
            );
            return "新增购物车商品成功";
        } else {
            throw new IllegalArgumentException("id不能为空");
        }

    }
}
