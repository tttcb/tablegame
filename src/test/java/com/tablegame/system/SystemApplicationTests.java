package com.tablegame.system;

import com.tablegame.system.service.CrawlerService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SystemApplicationTests {


	@Autowired
	private CrawlerService crawlerService;

	@Test
	@SneakyThrows
	void contextLoads() {
		System.out.println(crawlerService.getBaiduUrl());
	}

}
