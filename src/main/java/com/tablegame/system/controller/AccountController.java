package com.tablegame.system.controller;

import com.tablegame.system.common.Result;
import com.tablegame.system.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tu.cb
 */
@RequestMapping(value = "/tablegames/account")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    @ResponseBody
    public Result query(){
        return Result.success(accountService.query());
    }
}
