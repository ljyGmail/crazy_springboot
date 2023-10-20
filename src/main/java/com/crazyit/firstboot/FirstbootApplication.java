package com.crazyit.firstboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 执行该程序时传入如下参数:
// --book.name="Spring Boot" --port=9090
@SpringBootApplication
public class FirstbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstbootApplication.class, args);
	}
}
