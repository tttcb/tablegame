package com.tablegame.system.domain.dto;

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

    private Integer id;

    private String name;

    private String company;

    private Integer price;

    private String url;

    private String content;

    private Integer fundPersons;

    private Integer status;

    private String tag;

    private String playPersons;

    private String game_time;

    private String game_type;

    private String createBy;

    private String updateBy;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

    private Integer delFlag;
}
