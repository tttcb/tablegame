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
@TableName("criticize")
public class Criticize {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "user_id")
    private Integer userId;

    @TableField(value = "content")
    private String content;

    @TableField(value = "status")
    @ApiModelProperty("状态(无需填写)")
    private Integer status;

    @TableField(value = "order_id")
    @ApiModelProperty("商品ID")
    private Integer orderId;

    @TableField(value = "criticize_id")
    @ApiModelProperty("回复评论的ID")
    private Integer criticizeId;

}
