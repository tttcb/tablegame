package com.guiguohui.system.controller;

import com.guiguohui.system.common.Result;
import com.guiguohui.system.service.CommodityService;
import org.assertj.core.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author tu.cb
 */
@RequestMapping(value = "/guiguohui/fund")
@RestController
public class FundGamesController {

    @Autowired
    private CommodityService commodityService;



    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public Result query(@RequestParam(value = "gameId",required = false) Integer gameId, @RequestParam(value ="gameName",required = false) String gameName, @RequestParam(value ="gameType",required = false) Integer gameType) {
        return Result.success(commodityService.queryFundGames());
    }

    @RequestMapping(value = "/insert/{gameId}", method = RequestMethod.POST)
    @ResponseBody
    public Result insertFundGame(@PathVariable Integer gameId){
        return Result.success(Maps.newHashMap("gameId", commodityService.insertFundGame(gameId)));
    }
}
