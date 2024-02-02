package com.guiguohui.system.controller;

import com.guiguohui.system.common.PageHelper;
import com.guiguohui.system.domain.dto.Commodity;
import com.guiguohui.system.service.CommodityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
    @ApiOperation("搜索商品")
    public PageHelper<Commodity> search(
            @RequestParam(value = "commodityName", required = false) String commodityName,
            @RequestParam(value = "commoditytag", required = false) String commoditytag,
            @RequestParam(value = "commodityMaxPrice", required = false) Integer commodityMaxPrice,
            @RequestParam(value = "commodityMinPrice", required = false) Integer commodityMinPrice,
            @RequestParam(value = "commodityseason", required = false) Integer commoditySeason,
            @RequestParam(value = "pageIndex") Integer pageIndex,
            @RequestParam(value = "pageSize") Integer pageSize
            ) {
        return commodityService.search(commodityName, commoditytag, commodityMaxPrice, commodityMinPrice, commoditySeason,pageIndex,pageSize);
    }

    @RequestMapping(value = "/queryById", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("根据商品ID查找")
    public Commodity queryById(@RequestParam(
            value = "commodityId", required = false) Integer commodityId) {
        return commodityService.queryById(commodityId);
    }
/*

    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("查询所有商品")
    public List<Commodity> queryAll(){
        return commodityService.queryAll();
    }
*/


    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", required = true),
            @ApiImplicitParam(name = "shopId", required = true),
            @ApiImplicitParam(name = "price", required = true),
            @ApiImplicitParam(name = "content", required = true)
    })
    @ResponseBody
    @ApiOperation("新增商品")
    public String insert(Commodity commodity) {
        return commodityService.insert(commodity);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation("修改商品信息")
    @ApiImplicitParam(name = "id", required = true)
    public String update(Commodity commodity) {
        return commodityService.update(commodity);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation("删除商品")
    public String delete(@RequestParam("commodityId") Integer commodityId) {
        return commodityService.delete(commodityId);
    }

    @RequestMapping(value = "/changeStock", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("修改库存")
    public String changeStock(@RequestParam("count") Integer count,@RequestParam("commodityId") Integer commodityId) {
        return commodityService.changeStock(count,commodityId);
    }

    @RequestMapping(value = "/upLoadImage", method = RequestMethod.POST)
    @ApiImplicitParams({@ApiImplicitParam(name = "file", value = "文件流对象,接收数组格式", required = true,dataTypeClass = MultipartFile.class,dataType = "MultipartFile"),
            @ApiImplicitParam(name = "commodityId", value = "commodityId", required = true)}
    )
    @ResponseBody
    @ApiOperation("上传图片")
    public String upLoadImage(@RequestPart MultipartFile file,@RequestParam(value = "commodityId") Integer commodityId) throws IOException {
        return commodityService.upLoadImage(file,commodityId);
    }


    @RequestMapping(value = "/loadImage", method = RequestMethod.GET)
    @ApiOperation("读取图片")
    public String loadImage(@RequestParam(value = "commodityId") Integer commodityId, HttpServletResponse httpServletResponse) throws IOException {
        return commodityService.loadImage(commodityId,httpServletResponse);
    }
}
