package com.guiguohui.system.domain.dto;


import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author tu.cb
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("order")
public class Order {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "address")
    @ApiParam("收货地址")
    private String address;

    @TableField(value = "user_id")
    private Integer userId;

    @TableField(value = "pay_way")
    @ApiParam("支付方式")
    private Integer payWay;

    @TableField(value = "status")
    private Integer status ;

    @TableField(value = "price")
    @ApiParam("总价格")
    private Double price ;

    @ApiParam("订单详情")
    private List<OrderDetail> details ;

    @TableField(value = "date")
    @ApiParam("日期")
    private Date date;
}
