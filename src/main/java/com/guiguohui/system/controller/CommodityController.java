package com.guiguohui.system.controller;

import com.guiguohui.system.common.Result;
import com.guiguohui.system.domain.dto.Commodity;
import com.guiguohui.system.domain.dto.Shop;
import com.guiguohui.system.service.CommodityService;
import org.assertj.core.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author tu.cb
 */
@RestController
@RequestMapping(value = "/guiguohui/commodity")
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public Result query(@RequestParam(
            value = "commodityId", required = false) Integer commodityId,
                        @RequestParam(value = "commodityName", required = false) String commodityName,
                        @RequestParam(value = "commodityType", required = false) Integer commodityType,
                        @RequestParam(value = "commodityMaxPrice", required = false) Integer commodityMaxPrice,
                        @RequestParam(value = "commodityMinPrice", required = false) Integer commodityMinPrice,
                        @RequestParam(value = "commodityseason", required = false) Integer commoditySeason) {
        return Result.success(commodityService.query(commodityId, commodityName, commodityType,commodityMaxPrice,commodityMinPrice,commoditySeason));
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
}
