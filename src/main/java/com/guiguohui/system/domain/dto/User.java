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
    @ApiParam("昵称")
    private String nickname;

    /**
     * 地址
     */
    @TableField(value = "address")
    @ApiParam("收货地址")
    private String[] address;

    @TableField(value = "phone")
    @ApiParam("电话号码")
    private String phone;

    @TableField(value = "email")
    private String email;

    @TableField(value = "role")
    @ApiParam("角色")
    private String role;

    @TableField(value = "last_time")
    @ApiParam("上次登录的时间")
    private Date lastTime;

    @TableField(value = "status")
    private Integer status;

}
