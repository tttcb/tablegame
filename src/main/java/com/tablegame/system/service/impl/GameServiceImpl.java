package com.tablegame.system.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tablegame.system.common.AdminUserDetails;
import com.tablegame.system.domain.dto.Favor;
import com.tablegame.system.domain.dto.Fund;
import com.tablegame.system.domain.dto.Game;
import com.tablegame.system.mapper.FavorMapper;
import com.tablegame.system.mapper.FundMapper;
import com.tablegame.system.mapper.GameMapper;
import com.tablegame.system.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tu.cb
 */
@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameMapper gameMapper;

    @Autowired
    private FavorMapper favorMapper;

    @Autowired
    private FundMapper fundMapper;

    @Override
    public List<Game> query(Integer id, String gameName, Integer gameType) {
        QueryWrapper<Game> queryWrapper = new QueryWrapper<>();
        if (id != null) {
            queryWrapper.eq("id", id);
        } else {
            if (gameName != null) {
                queryWrapper.like("name", gameName);
            }
            if (gameType != null) {
                queryWrapper.eq("game_type", gameType);
            }
        }
        gameMapper.selectList(queryWrapper);
        return gameMapper.selectList(queryWrapper);
    }

    @Override
    public int insert(Game game) {
        return gameMapper.insert(game);
    }

    @Override
    public int update(Game game) {
        return gameMapper.updateById(game);
    }

    @Override
    public int delete(Integer id) {
        Game game = Game.builder().id(id).delFlag(1).build();
        return gameMapper.updateById(game);
    }

    @Override
    public int favorite(Integer id) {
        Favor favorgame = Favor.builder().id(id)
                .userId(((AdminUserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails()).getUserId())
                .createTime(DateTime.now())
                .updateTime(DateTime.now())
                .createBy(SecurityContextHolder.getContext().getAuthentication().getName())
                .build();
        return favorMapper.insert(favorgame);
    }

    @Override
    public List<Fund> queryFundGames() {
        QueryWrapper<Fund> query = new QueryWrapper<>();
        return fundMapper.selectList(query);
    }
}
