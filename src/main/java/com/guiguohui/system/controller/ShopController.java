package com.guiguohui.system.controller;

import com.guiguohui.system.common.Result;
import com.guiguohui.system.domain.dto.Shop;
import com.guiguohui.system.service.ShopService;
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
    private ShopService shopService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public Result search(
            @RequestParam(value = "shopName", required = false) String shopName) {
        return Result.success(shopService.search(shopName));
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(@Validated @RequestBody Shop shop) {
        return Result.success(shopService.insert(shop));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@Validated @RequestBody Shop shop) {
        return Result.success(shopService.update(shop));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@RequestParam("shopId") Integer shopId) {
        return Result.success(shopService.delete(shopId));
    }
}
