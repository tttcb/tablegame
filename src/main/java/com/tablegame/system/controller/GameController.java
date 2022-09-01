package com.tablegame.system.controller;

import com.tablegame.system.common.Result;
import com.tablegame.system.domain.dto.Game;
import com.tablegame.system.service.GameService;
import org.assertj.core.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author tu.cb
 */
@RestController
@RequestMapping("/tablegames/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public Result query(@RequestParam(value = "gameId",required = false) Integer gameId, @RequestParam(value ="gameName",required = false) String gameName, @RequestParam(value ="gameType",required = false) Integer gameType) {
        return Result.success(gameService.query(gameId, gameName, gameType));
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(@Validated @RequestBody Game game) {
        return Result.success(Maps.newHashMap("gameId",gameService.insert(game)));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@Validated @RequestBody Game game) {
        return Result.success(Maps.newHashMap("status",gameService.update(game)));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@RequestParam("gameId") Integer gameId) {
        return Result.success(Maps.newHashMap("status",gameService.delete(gameId)));
    }
}
