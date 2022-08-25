package com.tablegame.system.domain.dto;


import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author tu.cb
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("user_favor")
public class Favor {

    private Integer id;

    private String userId;
    
    private String tablegameId;

    private String createBy;

    private String updateBy;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

    private Integer delFlag;
}
