package com.guiguohui.system.controller;

import com.guiguohui.system.common.Result;
import com.guiguohui.system.domain.dto.Commodity;
import com.guiguohui.system.domain.dto.Order;
import com.guiguohui.system.domain.dto.OrderCommodity;
import com.guiguohui.system.service.CommodityService;
import com.guiguohui.system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/guiguohui/Order")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public Result queryById(@RequestParam Integer id) {
        return Result.success(orderService.queryById(id));
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public Result queryByUserId(@RequestParam("userId") Integer userId) {
        return Result.success(orderService.queryByUserId(userId));
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(@Validated @RequestBody Order order) {
        return Result.success(orderService.insert(order));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@Validated @RequestBody Order order) {
        return Result.success(orderService.update(order));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@RequestParam("commodityId") Integer id) {
        return Result.success(orderService.delete(id));
    }

    @RequestMapping(value = "/addCommodity", method = RequestMethod.POST)
    @ResponseBody
    public Result addCommodity(@RequestParam("commodityId") Integer id, @RequestParam("count") Integer count) {
        return Result.success(orderService.addCommodity(id, count));
    }

    @RequestMapping(value = "/deleteCommodity", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteCommodity(@RequestParam Integer id) {
        return Result.success(orderService.deleteCommodity(id));
    }

    @RequestMapping(value = "/queryGouWuChe", method = RequestMethod.GET)
    @ResponseBody
    public Result queryGouWuChe(@RequestParam("userId") Integer userId) {
        return Result.success(orderService.queryGouWuChe(userId));
    }
    @RequestMapping(value = "/updateGouWuChe", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateGouWuChe(@Validated @RequestBody OrderCommodity orderCommodity) {
        return Result.success(orderService.updateGouWuChe(orderCommodity));
    }


}
