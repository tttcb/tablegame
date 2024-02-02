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
@TableName("message")
public class Message {


    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "user_id")
    @ApiModelProperty("用户id")
    private Integer userId;

    @TableField(value = "content")
    @ApiModelProperty("内容")
    private String content;

    @TableField(value = "shop_id")
    @ApiModelProperty("店铺id")
    private Integer shopId;

    @TableField(value = "status")
    @ApiModelProperty("状态(无需填写)")
    private Integer status;

    @TableField(value = "message_id")
    @ApiModelProperty("回复留言的ID")
    private Integer messageId;


}

