package com.crazyit.firstboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
// 导入类加载路径下的fk/crazyit.properties文件
@PropertySource("classpath:/fk/crazyit.properties")
public class FirstbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstbootApplication.class, args);
	}
}
