package com.crazyit.firstboot.handler;

import com.crazyit.firstboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Component
public class ThymeleafHandler {

    public Mono<ServerResponse> login(ServerRequest request) {
        // 以异步方式获取表单请求参数
        // 获取表单请求参数用formData()方法
        // 如果获取POST请求体的数据，则用bodyToFlux()或bodyToMono()方法
        Mono<MultiValueMap<String, String>> mono = request.formData();
        /*
        Mono对象的flatMap()与map()方法很相似，
        都用于将当前Mono对象转换为另一个Mono对象，它们的区别在于:
        flatMap()会直接将传入的Lambda表达式的返回值作为新的Mono对象，
        因此其Lambda表达式必须返回Mono对象;
        map()会对传入的Lambda表达式的返回值再包装一层Mono,
        因此其Lambda表达式通常不返回Mono对象
         */
        return mono.flatMap(map -> {
            String username = map.get("username").get(0);
            String pass = map.get("pass").get(0);
            if (username.equals("crazyit.org") && pass.equals("ljy")) {
                request.session().subscribe(session -> {
                    // 添加Session数据
                    var data = session.getAttributes();
                    data.put("name", username);
                    data.put("role", "manager");
                });
                return ServerResponse.ok().contentType(MediaType.TEXT_HTML)
                        // 如果需要使用模板引擎，则调用render方法
                        // 如果要直接生成RESTful响应，则调用body()方法生成响应体
                        .render("main", Map.of("ids", List.of(1, 2, 3, 4)));
            }
            return ServerResponse.ok().contentType(MediaType.TEXT_HTML)
                    .render("index", Map.of("error", "用户名/密码不匹配"));
        });
    }

    @Autowired
    private BookService bookService;

    public Mono<ServerResponse> viewBook(ServerRequest request) {
        // 获取路径参数用pathVariable()方法
        // 获取请求参数(附在URL中的请求参数)用queryParam()方法
        String id = request.pathVariable("id");
        return ServerResponse.ok().contentType(MediaType.TEXT_HTML)
                .render("viewBook", Map.of("book", bookService.getBookById(Integer.parseInt(id))));
    }
}
