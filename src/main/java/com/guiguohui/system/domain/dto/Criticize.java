package com.guiguohui.system.domain.dto;

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
@TableName("criticize")
public class Criticize {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "user_role")
    private Integer userRole;

    @TableField(value = "user_id")
    private Integer userId;

    @TableField(value = "content")
    private String content;

    @TableField(value = "status")
    private Integer status;

    @TableField(value = "criticize_id")
    private Integer criticizeId;

}
