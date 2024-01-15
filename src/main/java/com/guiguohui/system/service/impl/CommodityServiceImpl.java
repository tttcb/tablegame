package com.guiguohui.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guiguohui.system.domain.dto.Commodity;
import com.guiguohui.system.mapper.CommodityMapper;
import com.guiguohui.system.service.CommodityService;
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
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityMapper commodityMapper;


    @Override
    public List<Commodity> query(Integer id, String commodityName, Integer commodityType, Integer commodityMaxPrice, Integer commodityMinPrice, Integer commoditySeason) {
        QueryWrapper<Commodity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", COMMODITY_ACTIVE);
        if (id != null) {
            queryWrapper.eq("id", id);
        } else {
            if (commodityName != null) {
                queryWrapper.like("name", commodityName);
            }
            if (commodityType != null) {
                queryWrapper.eq("type", commodityType);
            }
            if (commodityMaxPrice != null && commodityMinPrice != null) {
                queryWrapper.between("price", commodityMaxPrice,commodityMinPrice);
            }
            if (commoditySeason != null) {
                queryWrapper.like("season", commoditySeason);
            }
        }
        return commodityMapper.selectList(queryWrapper);
    }

    @Override
    public List<Commodity> query() {
       return query(null,null,null,null,null,null);
    }


    @Override
    public String insert(Commodity commodity) {
        Integer result = commodityMapper.insert(commodity);
        if (result.equals(1)) {
            return "新增商品成功";
        } else {
            return "新增商品失败";
        }
    }

    @Override
    public String update(Commodity commodity) {
        QueryWrapper<Commodity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", commodity.getId());
        queryWrapper.eq("status", COMMODITY_ACTIVE);
        Integer result = commodityMapper.update(commodity, queryWrapper);
        if (result.equals(1)) {
            return "更新商品成功";
        } else {
            return "更新商品失败";
        }
    }

    @Override
    public String delete(Integer id) {
        QueryWrapper<Commodity> queryWrapper = new QueryWrapper<>();
        if (id == null) {
            return "商品ID不能为空";
        }
        queryWrapper.eq("Id", id);
        if (commodityMapper.selectById(id) == null) {
            return "商品不存在";
        }
        if (Objects.equals(commodityMapper.selectById(id).getStatus(), COMMODITY_DELETE)) {
            return "商品已经被删除";
        }
        commodityMapper.update(Commodity.builder()
                .status(COMMODITY_DELETE)
                .build(), queryWrapper);
        return "删除用户成功";
    }


}
