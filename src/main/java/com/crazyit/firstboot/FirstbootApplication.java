package com.crazyit.firstboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
// 指定扫描指定包及其子包下的@ConfigurationProperties注解修饰的类
@ConfigurationPropertiesScan("com.crazyit.firstboot.app.config")
public class FirstbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstbootApplication.class, args);
	}
}
