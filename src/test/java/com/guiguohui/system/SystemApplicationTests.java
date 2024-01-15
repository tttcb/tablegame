package com.guiguohui.system;

import com.guiguohui.system.service.CrawlerService;
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
/*		for (Web web : crawlerService.getBaiduUrl()) {
			System.out.println(web.getTitle());
			System.out.println(web.getUrl());
		}*/
		String s = System.getProperty("line.separator");
		System.out.print("================================"+s);
		System.out.println("13");
		System.out.print(s);
		System.out.println("1");
	}

}
