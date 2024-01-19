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
@TableName("shop")
public class Shop {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "name")
    @ApiParam("店铺名称")
    private String name;

    @TableField(value = "status")
    private Integer status;

    @TableField(value = "type")
    @ApiParam("店铺类型")
    private Integer type;

    @TableField(value = "content")
    @ApiParam("店铺简介")
    private String content;

    @TableField(value = "user_id")
    @ApiParam("对应的用户ID")
    private Integer userId;


}
