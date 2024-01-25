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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("commodity")
public class Commodity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "name")
    @ApiModelProperty("商品名称")
    private String name;

    @TableField(value = "shop_id")
    @ApiModelProperty("商铺Id")
    private Integer shopId;

    @TableField(value = "company")
    @ApiModelProperty("生产公司")
    private String company;

    @TableField(value = "price")
    @ApiModelProperty("价格")
    private Double price;

    @TableField(value = "season")
    @ApiModelProperty("季节")
    private String season;

    @TableField(value = "weight")
    @ApiModelProperty("重量")
    private Integer weight ;

    @TableField(value = "producer")
    @ApiModelProperty("产地")
    private String producer;

    @TableField(value = "content")
    @ApiModelProperty("简介")
    private String content;

    @TableField(value = "stock")
    @ApiModelProperty("库存")
    private Integer stock;

    @TableField(value = "tag")
    @ApiModelProperty("标签")
    private String tag;

    @TableField(value = "status")
    @ApiModelProperty("状态(无需填写)")
    private Integer status;

}
