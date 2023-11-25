package com.crazyit.firstboot.ch03.websocket;

import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/websocket/{name}")
public class WebSocketEndpoint {
    public static Map<Session, String> socketMap = new ConcurrentHashMap<>();

    // 连接建立成功触发的方法
    @OnOpen
    public void onOpen(@PathParam("name") String name, Session session) {
        socketMap.put(session, name);
    }

    // 连接关闭时触发的方法
    @OnClose
    public void onClose(Session session) {
        socketMap.remove(session);
    }

    // 收到客户端消息后触发的方法
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.printf("收到来自%s的消息: %s%n", session, message);
        try {
            var name = socketMap.get(session);
            for (var client : socketMap.keySet()) {
                client.getBasicRemote().sendText(name + "说: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 发生错误时触发的方法
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        socketMap.remove(session);
    }
}
