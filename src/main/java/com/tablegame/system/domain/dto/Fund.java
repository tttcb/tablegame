package com.tablegame.system.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author tu.cb
 */
@Data
@TableName("tabletop_games_fund")
public class Fund {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "tablegameId")
    private Integer tablegameId;

    @TableField(value = "userId")
    private Integer userId;

    @TableField(value = "fund_price")
    private Integer fundPrice;

    @TableField(value = "status")
    private Integer status;

    @TableField(value = "create_by")
    private String createBy;

    @TableField(value = "update_by")
    private String updateBy;

    @TableField(value = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    @TableField(value = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

    @TableField(value = "del_flag")
    private Integer delFlag;
}
