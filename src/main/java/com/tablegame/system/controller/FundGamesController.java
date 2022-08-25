package com.tablegame.system.controller;

import com.tablegame.system.common.Result;
import com.tablegame.system.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author tu.cb
 */
@RequestMapping(value = "/tablegames/fund")
@RestController
public class FundGamesController {

    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public Result query(@RequestParam("gameId") Integer gameId, @RequestParam("gameName") String gameName, @RequestParam("gameType") String gameType) {
        return Result.success(gameService.queryFundGames());
    }
}
