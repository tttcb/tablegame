package com.guiguohui.system.controller;

import com.guiguohui.system.common.Result;
import com.guiguohui.system.domain.dto.Shop;
import com.guiguohui.system.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author tu.cb
 */
@RestController
@RequestMapping(value = "/guiguohui/shop")
public class ShopController {

    @Autowired
    private CommodityService commodityService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public Result query(@RequestParam(value = "shopId",required = false) Integer shopId, @RequestParam(value ="shopName",required = false) String gameName, @RequestParam(value ="shopType",required = false) Integer gameType) {
        return Result.success(commodityService.query(shopId, gameName, gameType));
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(@Validated @RequestBody Shop shop) {
        return Result.success(commodityService.insert(shop));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@Validated @RequestBody Shop shop) {
        return Result.success(commodityService.update(shop));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@RequestParam("shopId") Integer shopId) {
        return Result.success(commodityService.delete(shopId));
    }
}
