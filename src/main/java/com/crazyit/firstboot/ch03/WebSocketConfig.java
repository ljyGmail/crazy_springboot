package com.crazyit.firstboot.ch03;

import com.crazyit.firstboot.ch03.handler.ChatHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class WebSocketConfig {
    @Bean
    public HandlerMapping webSocketMapping(ChatHandler chatHandler) {
        // 使用HashMap定义WebSocket处理器与URL之间的对应关系
        Map<String, WebSocketHandler> map = new HashMap<>(1);
        map.put("/websocket/{name}", chatHandler);
        // 注册WebSocket处理器
        return new SimpleUrlHandlerMapping(map, -1);
    }

    @Bean
    public WebSocketHandlerAdapter handlerAdapter() {
        return new WebSocketHandlerAdapter();
    }
}
