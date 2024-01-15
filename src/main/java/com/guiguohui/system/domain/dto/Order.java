package com.guiguohui.system.domain.dto;


import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

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
    private String address;

    @TableField(value = "user_id")
    private Integer userId;

    @TableField(value = "pay_way")
    private Integer payWay;

    @TableField(value = "status")
    private Integer status ;

    @TableField(value = "price")
    private Double price ;

    @TableField(value = "details")
    private HashMap<Commodity, Integer> details ;

    @TableField(value = "date")
    private DateTime date;
}
