package com.crazyit.firstboot.app.listener;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ContainerEventListener implements ApplicationListener<WebServerInitializedEvent> {

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        System.out.println("动态HTTP端口为: " + event.getWebServer().getPort());
    }
}
