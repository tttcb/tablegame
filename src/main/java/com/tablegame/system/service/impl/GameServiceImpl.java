package com.tablegame.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tablegame.system.config.SecurityContext;
import com.tablegame.system.domain.dto.Favor;
import com.tablegame.system.domain.dto.Fund;
import com.tablegame.system.domain.dto.Game;
import com.tablegame.system.mapper.FavorMapper;
import com.tablegame.system.mapper.FundMapper;
import com.tablegame.system.mapper.GameMapper;
import com.tablegame.system.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
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
        queryWrapper.eq("del_flag", 0);
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
    public Integer insert(Game game) {
        game.setValue();
        gameMapper.insert(game);
        return game.getId();
    }

    @Override
    public Integer update(Game game) {
        QueryWrapper<Game> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", game.getId());
        queryWrapper.eq("del_flag", 0);
        return gameMapper.update(game, queryWrapper);
    }

    @Override
    public Integer delete(Integer id) {
        Game game = Game.builder().id(id).build();
        game.setDelFlag(1);
        QueryWrapper<Game> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", game.getId());
        queryWrapper.eq("del_flag", 0);
        return gameMapper.update(game,queryWrapper);
    }

    @Override
    public Integer favorite(Integer gameId) {
        Favor favorgame = Favor.builder().tabletopGameId(gameId)
                .userId(SecurityContext.getUserId())
                .build();
        favorgame.setValue();

        return favorMapper.insert(favorgame);
    }

    @Override
    public List<Fund> queryFundGames() {
        QueryWrapper<Fund> query = new QueryWrapper<>();
        return fundMapper.selectList(query);
    }

    @Override
    public Integer insertFundGame(Integer gameId) {
        Double price = gameMapper.selectById(gameId).getPrice();
        Fund fund = Fund.builder().tabletopGameId(gameId).userId(SecurityContext.getUserId()).fundPrice(price).build();
        fundMapper.insert(fund);
        return fund.getId();
    }


}
