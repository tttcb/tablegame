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

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_user")
public class User  {

    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField(value = "user_name")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 昵称
     */
    @TableField(value = "nick_name")
    @ApiModelProperty("昵称")
    private String nickname;


    @TableField(value = "phone")
    @ApiModelProperty("电话号码")
    private String phone;

    @TableField(value = "email")
    private String email;

    @TableField(value = "role")
    @ApiModelProperty("角色(1、商家,2、用户)")
    private String role;

    @TableField(value = "last_time")
    @ApiModelProperty("上次登录的时间(无需填写)")
    private Date lastTime;

    @TableField(value = "status")
    @ApiModelProperty("状态(无需填写)") 
    private Integer status;

}
