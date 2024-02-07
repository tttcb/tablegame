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
@TableName("address")
public class Address {

    @TableId(type = IdType.AUTO)
    private String id;

    @TableField(value = "recipient")
    @ApiModelProperty("收件人")
    private String recipient;

    @TableField(value = "phone")
    @ApiModelProperty("电话号码")
    private String phone;

    @TableField(value = "address")
    @ApiModelProperty("地址")
    private String address;

    @TableField(value = "user_id")
    private Integer userId;

    @TableField(value = "status")
    @ApiModelProperty("状态")
    private Integer status;
}
