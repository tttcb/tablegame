package com.tablegame.system.common;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;

/**
 * @author tu.cb
 */
@Data
public class BaseDTO {

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

    public void setValue(){
        this.createTime= DateTime.now();
        this.updateTime= DateTime.now();
        this.createBy= SecurityContextHolder.getContext().getAuthentication().getName();
        this.updateBy= SecurityContextHolder.getContext().getAuthentication().getName();
        this.delFlag=0;
    }
}
