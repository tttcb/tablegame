package com.guiguohui.system.controller;

import com.guiguohui.system.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author tu.cb
 */
@Controller
public class CrawlerController {

    @Autowired
    private CrawlerService crawlerService;

}

