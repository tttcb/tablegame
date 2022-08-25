package com.tablegame.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tablegame.system.domain.dto.Game;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author tu.cb
 */
@Mapper
public interface GameMapper extends BaseMapper<Game> {


}
