package com.tablegame.system.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tablegame.system.common.BaseDTO;
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
public class Game extends BaseDTO {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "company")
    private String company;

    @TableField(value = "price")
    private Double price;

    @TableField(value = "url")
    private String url;

    @TableField(value = "content")
    private String content;

    @TableField(value = "fund_persons")
    private Integer fundPersons;

    @TableField(value = "status")
    private Integer status;

    @TableField(value = "tag")
    private Integer tag;

    @TableField(value = "play_persons")
    private String playPersons;

    @TableField(value = "play_time")
    private String playTime;

    @TableField(value = "game_type")
    private Integer gameType;


}
