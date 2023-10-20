package com.crazyit.firstboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

// 额外指定扫描com.crazyit.firstboot和org.fkit.app包及其子包下所有的配置类和Bean组件
@SpringBootApplication(scanBasePackages = {"com.crazyit.firstboot", "org.fkit.app"})
// 加载类路径下的beans.xml文件作为配置文件
@ImportResource("classpath:beans.xml")
// 加载con.fkjava.app包下的MyConfig文件作为配置类
@Import(cn.fkjava.app.MyConfig.class)
public class FirstbootApplication {

    public static void main(String[] args) {
        // 2.2.2 利用JSON参数配置
        System.setProperty("spring.application.json",
                "{\"fkjava\":{\"name\":\"Crazy IT\", \"age\":30," +
                "\"servers\":[\"fkjava.org\", \"crazyit.org\"]}}");

        // 创建Spring容器，运行Spring Boot应用
        // SpringApplication.run(FirstbootApplication.class, args);

        // 2.1.5 设置SPringApplication与流式API
        // 创建SpringApplication对象
        var application = new SpringApplication(FirstbootApplication.class);
        application.setLazyInitialization(false);
        Banner banner = (environment, sourceClass, out) -> out.println("My Spring Boot");
        application.setBanner(banner);
        // 2.1.9 创建非Web应用
        // 设置创建非Web应用
        // application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }
}
