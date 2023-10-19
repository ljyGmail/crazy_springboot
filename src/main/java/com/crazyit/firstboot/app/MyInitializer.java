package com.crazyit.firstboot.app;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class MyInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        // 接下来的代码可对Spring容器执行任意初始化
        System.out.println("=====模拟对Spring容器执行初始化=====");
    }
}
