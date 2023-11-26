package com.crazyit.firstboot.ch03.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class SimpleHandler implements WebSocketHandler {
    @Override
    public Mono<Void> handle(WebSocketSession session) {
        // 接收消息流
        Flux<WebSocketMessage> output=session.receive()
                // 把消息(Flux中的数据)恢复成WebSocketMessage
                .map(value->session.textMessage("回复: "+value.getPayloadAsText()));
        // 发送消息流
        return session.send(output);
    }
}
