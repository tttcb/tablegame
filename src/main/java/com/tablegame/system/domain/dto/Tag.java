package com.tablegame.system.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tablegame.system.common.BaseDTO;
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
@TableName("tabletop_games_tag")
public class Tag extends BaseDTO {

    @TableId(type = IdType.AUTO)
    public Integer id;

    @TableField(value = "tag_name")
    public String name;
}
