package com.guiguohui.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guiguohui.system.domain.dto.Criticize;
import com.guiguohui.system.domain.dto.Message;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author tu.cb
 */
@Mapper
public interface MessageMapper extends BaseMapper<Message> {

}
