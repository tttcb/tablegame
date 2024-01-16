package com.guiguohui.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guiguohui.system.domain.dto.Order;
import com.guiguohui.system.domain.dto.OrderCommodity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author tu.cb
 */
@Mapper
public interface OrderCommodityMapper extends BaseMapper<OrderCommodity> {

}
