package com.tablegame.system.controller;

import com.tablegame.system.common.Result;
import com.tablegame.system.domain.dto.Game;
import com.tablegame.system.service.GameService;
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
    public Result query(@RequestParam("gameId") Integer gameId, @RequestParam("gameName") String gameName, @RequestParam("gameType") Integer gameType) {
        return Result.success(gameService.query(gameId, gameName, gameType));
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(@Validated @RequestBody Game game) {
        return Result.success(gameService.insert(game));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@Validated @RequestBody Game game) {
        return Result.success(gameService.update(game));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@RequestParam("gameId") Integer gameId) {
        return Result.success(gameService.delete(gameId));
    }
}
