package com.guiguohui.system.domain.dto;


import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
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
@TableName("c_order")
public class Order {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "address")
    @ApiModelProperty("收货地址")
    private String address;

    @TableField(value = "user_id")
    private Integer userId;

    @TableField(value = "pay_way")
    @ApiModelProperty("支付方式")
    private Integer payWay;

    @TableField(value = "status")
    @ApiModelProperty("状态(无需填写)")
    private Integer status ;

    @TableField(value = "price")
    @ApiModelProperty("总价格")
    private Double totalPrice ;

    @TableField(exist = false)
    @ApiModelProperty("订单详情(无需填写)")
    private List<OrderDetail> details ;

    @TableField(value = "date")
    @ApiModelProperty("日期(无需填写)")
    private Date date;
}
