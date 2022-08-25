package com.tablegame.system.domain.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author tu.cb
 */
@Data
@TableName("url")
public class WebUrl {

    private Integer id;

    private String url;

    private String remark;

}
