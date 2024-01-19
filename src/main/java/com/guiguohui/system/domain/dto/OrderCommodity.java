package com.guiguohui.system.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("order_commodity")
public class OrderCommodity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "commodity_id")
    @ApiParam("商品ID")
    private Integer commodityId;

    @TableField(value = "order_id")
    @ApiParam("订单ID")
    private Integer orderId;

    @TableField(value = "price")
    @ApiParam("单价")
    private Double price;

    @TableField(value = "tag")
    @ApiParam("标签")
    private String tag;

    @TableField(value = "count")
    @ApiParam("数量")
    private Integer count;

    @TableField(value = "status")
    private Integer status ;

}
