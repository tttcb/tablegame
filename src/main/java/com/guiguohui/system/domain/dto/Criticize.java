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

    @TableField(value = "commodity_id")
    @ApiModelProperty("商品Id")
    private Integer commodityId;

    @TableField(value = "criticize_id")
    @ApiModelProperty("回复评论的ID")
    private Integer criticizeId;

}
