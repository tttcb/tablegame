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

/**
 * @author tu.cb
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("tag")
public class Tag  {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "name")
    @ApiModelProperty("标签名称")
    private String name;

    @TableField(value = "status")
    @ApiModelProperty("状态(无需填写)")
    private Integer status;

}
