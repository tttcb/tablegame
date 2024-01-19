package com.guiguohui.system.controller;

import com.guiguohui.system.domain.dto.Order;
import com.guiguohui.system.domain.dto.OrderCommodity;
import com.guiguohui.system.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/guiguohui/Order")
@Api(tags = "订单、购物车相关接口")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/queryById", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("根据Id查询订单详情")
    public Order queryById(@RequestParam Integer id) {
        return orderService.queryById(id);
    }

    @RequestMapping(value = "/queryByUserId", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("根据用户ID查询订单详情")
    public List<Order> queryByUserId(@RequestParam("userId") Integer userId) {
        return orderService.queryByUserId(userId);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("新增订单")
    public String insert(@Validated @RequestBody Order order) {
        return orderService.insert(order);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation("更新订单")
    public String update(@Validated @RequestBody Order order) {
        return orderService.update(order);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation("删除订单")
    public String delete(@RequestParam("commodityId") Integer id) {
        return orderService.delete(id);
    }

    @RequestMapping(value = "/addCommodity", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("添加购物车商品")
    public String addCommodity(@RequestParam("commodityId") Integer id, @RequestParam("count") Integer count) {
        return orderService.addCommodity(id, count);
    }

    @RequestMapping(value = "/deleteCommodity", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation("删除购物车商品")
    public String deleteCommodity(@RequestParam Integer id) {
        return orderService.deleteCommodity(id);
    }

    @RequestMapping(value = "/queryGouWuChe", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("查询购物车商品")
    public List<OrderCommodity> queryGouWuChe(@RequestParam("userId") Integer userId) {
        return orderService.queryGouWuChe(userId);
    }
    @RequestMapping(value = "/updateGouWuChe", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation("修改购物车商品数量")
    public String updateGouWuChe(@Validated @RequestBody OrderCommodity orderCommodity) {
        return orderService.updateGouWuChe(orderCommodity);
    }


}
