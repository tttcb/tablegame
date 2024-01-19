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
@TableName("commodity")
public class Commodity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "shop_id")
    private Integer shopId;

    @TableField(value = "company")
    private String company;

    @TableField(value = "price")
    private Double price;

    @TableField(value = "season")
    private String season;

    @TableField(value = "weight")
    private Integer weight ;

    @TableField(value = "producer")
    private String producer;

    @TableField(value = "content")
    private String content;

    @TableField(value = "stock")
    private Integer stock;

    @TableField(value = "tag")
    private String tag;

    @TableField(value = "status")
    private Integer status;

}
