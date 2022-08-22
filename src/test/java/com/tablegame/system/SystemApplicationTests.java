package com.tablegame.system;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@SpringBootTest
class SystemApplicationTests {

	@Test
	void contextLoads() {
		BCryptPasswordEncoder password = new BCryptPasswordEncoder();
		System.out.println(password.encode("tcb123"));
		System.out.println(password.encode("zwy123"));
		System.out.println(password.encode("zbw123"));
		System.out.println(password.encode("szf123"));
		System.out.println(password.encode("sxy123"));
		System.out.println(password.encode("hm123"));
		System.out.println(password.encode("zkk123"));
		System.out.println(password.encode("sdm123"));
		System.out.println(password.encode("wlt123"));
		System.out.println(password.encode("hcy123"));
		System.out.println(password.encode("hz123"));
	}

}
