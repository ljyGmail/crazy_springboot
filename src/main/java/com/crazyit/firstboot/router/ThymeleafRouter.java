package com.crazyit.firstboot.router;

import com.crazyit.firstboot.handler.ThymeleafHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ThymeleafRouter {

    @Bean
    public RouterFunction<ServerResponse> route(ThymeleafHandler handler) {
        return RouterFunctions
                .route(RequestPredicates.POST("/login")
                        .and(RequestPredicates.accept(MediaType.TEXT_HTML)), handler::login)
                .andRoute(RequestPredicates.GET("/viewBook/{id}")
                        .and(RequestPredicates.accept(MediaType.TEXT_HTML)), handler::viewBook);
    }
}
