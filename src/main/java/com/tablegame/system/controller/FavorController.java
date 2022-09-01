package com.tablegame.system.controller;

import com.tablegame.system.common.Result;
import com.tablegame.system.service.GameService;
import org.assertj.core.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author tu.cb
 */
@RestController
@RequestMapping("/tablegames/favor")
public class FavorController {

    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/insert/{gameId}" , method = RequestMethod.POST)
    @ResponseBody
    public Result insert(@PathVariable Integer gameId){
        return Result.success(Maps.newHashMap("Id",gameService.favorite(gameId)));
    }
}
