package com.guiguohui.system.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

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
    @ApiModelProperty("商品ID")
    private Integer commodityId;


    @TableField(value = "address_id")
    @ApiModelProperty("收货地址id")
    private String addressId;

    @ApiModelProperty("收货地址详情")
    @TableField(exist = false)
    private Address address;

    @TableField(value = "order_id")
    @ApiModelProperty("订单ID")
    private Integer orderId;

    @TableField(value = "price")
    @ApiModelProperty("单价")
    private Double price;

    @TableField(value = "tag")
    @ApiModelProperty("标签")
    private String tag;

    @TableField(value = "count")
    @ApiModelProperty("数量")
    private Integer count;

    @TableField(value = "status")
    @ApiModelProperty("状态(无需填写)")
    private Integer status;

}
