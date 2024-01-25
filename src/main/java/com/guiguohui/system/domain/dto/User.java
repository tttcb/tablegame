package com.guiguohui.system.domain.dto;

import cn.hutool.json.JSONArray;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static com.guiguohui.system.common.Parameter.FENGEFU;

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

    /**
     * 地址
     */
    @TableField(value = "address")
    @ApiModelProperty("收货地址数据转换（无需填写）")
    private String addressResult;

    @ApiModelProperty("收货地址")
    private String[] address;

    @TableField(value = "phone")
    @ApiModelProperty("电话号码")
    private String phone;

    @TableField(value = "email")
    private String email;

    @TableField(value = "role")
    @ApiModelProperty("角色")
    private String role;

    @TableField(value = "last_time")
    @ApiModelProperty("上次登录的时间(无需填写)")
    private Date lastTime;

    @TableField(value = "status")
    @ApiModelProperty("状态(无需填写)") 
    private Integer status;

    public User convert(User user) {
        if (user.address != null){
            StringBuilder result = new StringBuilder();
            for(String a: user.address)
            {
                result.append(a).append(FENGEFU);
            }
            user.addressResult = result.toString();
            user.address=null;
        }
        return user;
    }

    public User reconvert(User user) {
        if (user.addressResult != null){
            String[] temp= user.addressResult.split(FENGEFU);
            String[] result = new String[temp.length];
            int i = 0;
            for(String a: temp)
            {
                result[i++] = a ;
            }
            user.address = result;
        }
        return user;
    }
}
