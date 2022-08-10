package com.tablegame.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_user")
public class User {

    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    public String id;

    /**
     * 用户名
     */
    @TableField(value = "user_name")
    public String username;

    /**
     * 密码
     */
    @TableField(value = "password")
    public String password;

    /**
     * 昵称
     */
    @TableField(value = "nick_name")
    public String nickname;

    private String createBy;

    private String updateBy;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

    private Integer delFlag;
}
