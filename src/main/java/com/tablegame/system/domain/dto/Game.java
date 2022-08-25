package com.tablegame.system.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tabletop_games")
public class Game {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "company")
    private String company;

    @TableField(value = "price")
    private Integer price;

    @TableField(value = "url")
    private String url;

    @TableField(value="content")
    private String content;

    @TableField(value = "fund_persons")
    private Integer fundPersons;

    @TableField(value = "status")
    private Integer status;

    @TableField(value = "tag")
    private String tag;

    @TableField(value = "play_persons")
    private String playPersons;

    @TableField(value = "game_time")
    private String gameTime;

    @TableField(value = "game_type")
    private String gameType;

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
