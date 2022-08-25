package com.tablegame.system.service;

import com.tablegame.system.domain.dto.Fund;
import com.tablegame.system.domain.dto.Game;

import java.util.List;

/**
 * @author tu.cb
 */
public interface GameService {

    /**
     * 查询列表
     *
     * @param id
     * @return
     */
    List<Game> query(Integer id, String gameName, Integer gameType);

    /**
     * 插入
     * @param game
     * @return
     */
    int insert(Game game);

    /**
     * 更新
     * @param game
     * @return
     */
    int update(Game game);

    /**
     * 删除
     * @param
     * @return
     */
    int delete(Integer id);

    /**
     * 添加为心仪桌游
     * @param id
     * @return
     */
    int favorite(Integer id);

    /**
     * 查询众筹
     * @return
     */
    List<Fund> queryFundGames();
}
