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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("tabletop_games_fund")
public class Fund extends BaseDTO {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "tabletop_game_id")
    private Integer tabletopGameId;

    @TableField(value = "user_id")
    private Integer userId;

    @TableField(value = "fund_price")
    private Double fundPrice;

    @TableField(value = "status")
    private Integer status;

}
