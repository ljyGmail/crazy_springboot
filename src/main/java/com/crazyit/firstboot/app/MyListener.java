package com.crazyit.firstboot.app;

import org.springframework.beans.BeansException;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

public class MyListener implements ApplicationContextAware, ApplicationListener<ApplicationStartedEvent> {

    private ApplicationContext ctx;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        // 获取触发事件的容器
        ConfigurableApplicationContext c = event.getApplicationContext();
        if (c == ctx) {
            System.out.println("-----触发事件的容器与监听器所在的容器相同-----");
        }
        // 后面的代码可插入任意自定义处理
        System.out.println("==========执行自定义处理==========");
    }

    // 接口注入方法，通过该方法可访问Spring容器
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }
}
