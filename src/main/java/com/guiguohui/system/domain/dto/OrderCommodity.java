package com.guiguohui.system.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("orderCommodity")
public class OrderCommodity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "commodity_id")
    private Integer commodityId;

    @TableField(value = "order_id")
    private Integer orderId;

    @TableField(value = "price")
    private Double price;

    @TableField(value = "tag")
    private Integer tag;

    @TableField(value = "count")
    private Integer count;

    @TableField(value = "status")
    private Integer status ;

}
