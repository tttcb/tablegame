package com.tablegame.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tablegame.system.domain.dto.WebUrl;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CrawlerManager extends BaseMapper<WebUrl> {

}
