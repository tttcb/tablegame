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
@TableName("message")
public class Message {


    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "user_id")
    @ApiParam("用户id")
    private Integer userId;

    @TableField(value = "content")
    @ApiParam("简介")
    private String content;

    @TableField(value = "shop_id")
    @ApiParam("店铺id")
    private Integer shopId;

    @TableField(value = "status")
    private Integer status;

    @TableField(value = "message_id")
    @ApiParam("回复留言的ID")
    private Integer messageId;


}

