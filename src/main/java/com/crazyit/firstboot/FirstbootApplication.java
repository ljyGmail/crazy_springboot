package com.crazyit.firstboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstbootApplication {

    public static void main(String[] args) {
        var app = new SpringApplication(FirstbootApplication.class);
        // 添加Profile
        app.setAdditionalProfiles("addition");
        app.run(args);
    }
}
