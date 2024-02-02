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

import javax.validation.constraints.NotNull;

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

    @TableField(value = "user_id")
    private Integer userId;

    @TableField(value = "content")
    @ApiModelProperty("内容")
    private String content;

    @TableField(value = "status")
    @ApiModelProperty("状态(1、未读，2、已读，3、删除)")
    private Integer status;

    @TableField(value = "type")
    @ApiModelProperty("通知类型")
    private Integer type;

}
