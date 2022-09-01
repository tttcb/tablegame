package com.tablegame.system.controller;

import com.tablegame.system.common.Result;
import com.tablegame.system.service.GameService;
import org.assertj.core.util.Maps;
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
    public Result query(@RequestParam(value = "gameId",required = false) Integer gameId, @RequestParam(value ="gameName",required = false) String gameName, @RequestParam(value ="gameType",required = false) Integer gameType) {
        return Result.success(gameService.queryFundGames());
    }

    @RequestMapping(value = "/insert/{gameId}", method = RequestMethod.POST)
    @ResponseBody
    public Result insertFundGame(@PathVariable Integer gameId){
        return Result.success(Maps.newHashMap("gameId",gameService.insertFundGame(gameId)));
    }
}
