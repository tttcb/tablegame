package com.guiguohui.system.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tu.cb
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("notice")
public class Notice {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "order_id")
    private Integer orderId;

    @TableField(value = "user_id")
    private Integer userId;

    @TableField(value = "content")
    private String content;

    @TableField(value = "status")
    private Integer status;

    @TableField(value = "type")
    private Integer type;

}
