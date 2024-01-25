package com.guiguohui.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guiguohui.system.common.PageHelper;
import com.guiguohui.system.domain.dto.Callback;
import com.guiguohui.system.domain.dto.Shop;
import com.guiguohui.system.domain.dto.Shop;
import com.guiguohui.system.mapper.ShopMapper;
import com.guiguohui.system.mapper.ShopMapper;
import com.guiguohui.system.service.ShopService;
import com.guiguohui.system.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.guiguohui.system.common.Parameter.COMMODITY_ACTIVE;
import static com.guiguohui.system.common.Parameter.COMMODITY_DELETE;

/**
 * @author tu.cb
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;


    public PageHelper<Shop> search(String shopName, Integer pageIndex, Integer pageSize) {
        QueryWrapper<Shop> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", COMMODITY_ACTIVE);
        if (shopName != null) {
            queryWrapper.like("name", "%"+shopName+"%");
        }
        List<Shop> data = shopMapper.selectList(queryWrapper);
        PageHelper<Shop> result = new PageHelper<>(0,pageSize, pageIndex,data);
        result.init();
        return result;
    }

    @Override
    public PageHelper<Shop> queryAll(Integer pageIndex, Integer pageSize) {
        return search(null,  pageIndex,  pageSize);
    }


    @Override
    public String insert(Shop shop) {
        shop.setStatus(COMMODITY_ACTIVE);
        Integer result = shopMapper.insert(shop);
        if (result.equals(1)) {
            return "新增店铺成功";
        } else {
            return "新增店铺失败";
        }
    }

    @Override
    public String update(Shop shop) {
        QueryWrapper<Shop> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", shop.getId());
        queryWrapper.eq("status", COMMODITY_ACTIVE);
        Integer result = shopMapper.update(shop, queryWrapper);
        if (result.equals(1)) {
            return "更新店铺信息成功";
        } else {
            return "更新店铺信息失败";
        }
    }

    @Override
    public String delete(Integer id) {
        QueryWrapper<Shop> queryWrapper = new QueryWrapper<>();
        if (id == null) {
            return "店铺ID不能为空";
        }
        queryWrapper.eq("Id", id);
        if (shopMapper.selectById(id) == null) {
            return "店铺不存在";
        }
        if (Objects.equals(shopMapper.selectById(id).getStatus(), COMMODITY_DELETE)) {
            return "店铺已经被删除";
        }
        shopMapper.update(Shop.builder()
                .status(COMMODITY_DELETE)
                .build(), queryWrapper);
        return "删除店铺成功";
    }



}
