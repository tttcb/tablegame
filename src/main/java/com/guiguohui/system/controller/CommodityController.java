package com.guiguohui.system.controller;

import com.guiguohui.system.common.Result;
import com.guiguohui.system.domain.dto.Commodity;
import com.guiguohui.system.domain.dto.Shop;
import com.guiguohui.system.service.CommodityService;
import io.swagger.annotations.Api;
import org.assertj.core.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author tu.cb
 */
@RestController
@RequestMapping(value = "/guiguohui/commodity")
@Api(tags = "商品相关接口")
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public Result search(
            @RequestParam(value = "commodityName", required = false) String commodityName,
            @RequestParam(value = "commodityType", required = false) Integer commodityType,
            @RequestParam(value = "commodityMaxPrice", required = false) Integer commodityMaxPrice,
            @RequestParam(value = "commodityMinPrice", required = false) Integer commodityMinPrice,
            @RequestParam(value = "commodityseason", required = false) Integer commoditySeason) {
        return Result.success(commodityService.search(commodityName, commodityType, commodityMaxPrice, commodityMinPrice, commoditySeason));
    }

    @RequestMapping(value = "/queryById", method = RequestMethod.GET)
    @ResponseBody
    public Result queryById(@RequestParam(
            value = "commodityId", required = false) Integer commodityId) {
        return Result.success(commodityService.queryById(commodityId));
    }

    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    @ResponseBody
    public Result queryAll(){
        return Result.success(commodityService.queryAll());
    }


    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(@Validated @RequestBody Commodity commodity) {
        return Result.success(commodityService.insert(commodity));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@Validated @RequestBody Commodity commodity) {
        return Result.success(commodityService.update(commodity));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@RequestParam("commodityId") Integer commodityId) {
        return Result.success(commodityService.delete(commodityId));
    }

    @RequestMapping(value = "/changeStock", method = RequestMethod.POST)
    @ResponseBody
    public Result changeStock(@RequestParam("count") Integer count,@RequestParam("commodityId") Integer commodityId) {
        return Result.success(commodityService.changeStock(count,commodityId));
    }
}
