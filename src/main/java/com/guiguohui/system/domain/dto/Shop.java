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
@TableName("shop")
public class Shop {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "name")
    @ApiModelProperty("店铺名称")
    private String name;

    @TableField(value = "status")
    @ApiModelProperty("状态(无需填写)")
    private Integer status;

/*    @TableField(value = "type")
    @ApiModelProperty("店铺类型")
    private Integer type;*/

    @TableField(value = "content")
    @ApiModelProperty("店铺简介")
    private String content;

    @TableField(value = "user_id")
    @ApiModelProperty("用户ID")
    private Integer userId;


}
