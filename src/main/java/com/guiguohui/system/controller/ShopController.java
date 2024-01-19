package com.guiguohui.system.controller;

import com.guiguohui.system.domain.dto.Shop;
import com.guiguohui.system.service.ShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tu.cb
 */
@RestController
@RequestMapping(value = "/guiguohui/shop")
@Api(tags = "店铺相关接口")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("搜索店铺")
    public List<Shop> search(
            @RequestParam(value = "shopName", required = false) String shopName) {
        return shopService.search(shopName);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("新增店铺")
    public String insert(@Validated @RequestBody Shop shop) {
        return shopService.insert(shop);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation("更新店铺信息")
    public String update(@Validated @RequestBody Shop shop) {
        return shopService.update(shop);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation("删除店铺")
    public String delete(@RequestParam("shopId") Integer shopId) {
        return shopService.delete(shopId);
    }
}
