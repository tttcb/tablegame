package com.guiguohui.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guiguohui.system.domain.dto.Commodity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author tu.cb
 */
@Mapper
public interface CommodityMapper extends BaseMapper<Commodity> {

    List<Commodity> search(String commodityName, String commodityType, Integer commodityMaxPrice, Integer commodityMinPrice, Integer commoditySeason,Integer shopId);
}
