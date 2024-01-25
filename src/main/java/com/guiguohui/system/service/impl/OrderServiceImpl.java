package com.guiguohui.system.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guiguohui.system.common.PageHelper;
import com.guiguohui.system.config.SecurityContext;
import com.guiguohui.system.domain.dto.*;
import com.guiguohui.system.mapper.OrderCommodityMapper;
import com.guiguohui.system.mapper.OrderMapper;
import com.guiguohui.system.service.CommodityService;
import com.guiguohui.system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
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
    public String insert(Order order) throws ParseException {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        order.setDate(dft.parse(DateTime.now().toString()));
        order.setStatus(ORDER_PAY);
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", order.getUserId());
        queryWrapper.eq("status",ORDER_GOUWUCHE);
        Integer result = orderMapper.update(order, queryWrapper);
        if (result.equals(1)) {
            addGouWuChe(order.getUserId());
            return "更新订单成功";
        } else {
            return "更新订单失败";
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
            queryWrapper.eq("order_id", queryGouWuCheId(userId).getId());
            queryWrapper.eq("status", ORDERCOMMODITY_ACTIVE);
            return orderCommodityMapper.selectList(queryWrapper);
        } else {
            throw new IllegalArgumentException("id不能为空");
        }
    }


    public Void addGouWuChe(Integer userId) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            orderMapper.insert(Order.
                    builder().status(ORDER_GOUWUCHE)
                    .date(dft.parse(DateTime.now().toString()))
                    .userId(userId)
                    .build())
            ;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public String updateGouWuChe(Integer orderCommodityId, Integer count) {
        QueryWrapper<OrderCommodity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", orderCommodityId);
        queryWrapper.eq("status", ORDERCOMMODITY_ACTIVE);
        Integer result = orderCommodityMapper.update(OrderCommodity.builder().count(count).build(), queryWrapper);
        if (result.equals(1)) {
            return "更新购物车商品成功";
        } else {
            return "更新购物车商品失败";
        }
    }


    @Override
    public PageHelper<Order> queryByUserId(Integer userId, Integer pageIndex, Integer pageSize) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        if (userId == null) {
            throw new IllegalArgumentException("用户ID不能为空");
        }
        queryWrapper.eq("user_Id", userId);
        queryWrapper.eq("status",ORDER_NOTPAY).or().eq("status",ORDER_PAY);
        List<Order> data = orderMapper.selectList(queryWrapper);
        int index = 0 ;
        for (Order order : data){
            QueryWrapper<OrderCommodity> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("order_id", order.getId());
            queryWrapper1.eq("status",ORDERCOMMODITY_ACTIVE);
            List<OrderCommodity> orderCommodities = orderCommodityMapper.selectList(queryWrapper1);
            List<OrderDetail> details = new ArrayList<>();
            for (OrderCommodity orderCommodity : orderCommodities) {
                OrderDetail detail = new OrderDetail(orderCommodity);
                details.add(detail);
            }
            order.setDetails(details);
            data.set(index++, order);
        }
        PageHelper<Order> result = new PageHelper<>(0, pageSize, pageIndex, data);
        result.init();
        return result;
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
            Order result = orderMapper.selectById(id);
            QueryWrapper<OrderCommodity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("order_id", result.getId());
            queryWrapper.eq("status",ORDERCOMMODITY_ACTIVE);
            List<OrderCommodity> orderCommodities = orderCommodityMapper.selectList(queryWrapper);
            List<OrderDetail> details = new ArrayList<>();
            for (OrderCommodity orderCommodity : orderCommodities) {
                OrderDetail detail = new OrderDetail(orderCommodity);
                details.add(detail);
            }
            result.setDetails(details);
            return result;

        } else {
            throw new IllegalArgumentException("id不能为空");
        }
    }

    public Order queryGouWuCheId(Integer userId) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("status", ORDER_GOUWUCHE);
        if (userId != null) {
            return orderMapper.selectOne(queryWrapper);
        } else {
            throw new IllegalArgumentException("id不能为空");
        }
    }

    @Override
    public String addCommodity(Integer id, Integer count) {
      Integer userid = SecurityContext.getUserId();
        if (userid == null) {
            throw new IllegalArgumentException("userid cannot be null");
        }
        if (id != null) {
            Commodity commodity = commodityService.queryById(id);
            orderCommodityMapper.insert(
                    OrderCommodity.builder()
                            .orderId(queryGouWuCheId(userid).getId())
                            .price(commodity.getPrice())
                            .count(count)
                            .commodityId(id)
                            .name(commodity.getName())
                            .tag(commodity.getTag())
                            .status(ORDERCOMMODITY_ACTIVE)
                            .build()
            );
            return "新增购物车商品成功";
        } else {
            throw new IllegalArgumentException("id不能为空");
        }

    }
/*
    public String addCommodity(Integer id, Integer count, Integer orderId) {
        if (id != null) {
            Commodity commodity = commodityService.queryById(id);
            orderCommodityMapper.insert(
                    OrderCommodity.builder()
                            .orderId(orderId)
                            .price(commodity.getPrice())
                            .count(count)
                            .commodityId(id)
                            .name(commodity.getName())
                            .tag(commodity.getTag())
                            .build()
            );
            return "新增订单商品成功";
        } else {
            throw new IllegalArgumentException("id不能为空");
        }

    }*/
}
