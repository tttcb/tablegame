package com.guiguohui.system.domain.dto;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String nickname;

    /**
     * 地址
     */
    @TableField(value = "address")
    private String[] address;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "email")
    private String email;

    @TableField(value = "role")
    private Integer role;

    @TableField(value = "last_time")
    private DateTime lastTime;

    @TableField(value = "status")
    private Integer status;

}
