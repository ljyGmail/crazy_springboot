package com.crazyit.firstboot.app;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.Compression;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.util.unit.DataSize;

import java.time.Duration;

@Configuration
public class AppConfig {
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory=new TomcatServletWebServerFactory();
        // 设置端口
        factory.setPort(8081);
        Session session=new Session();
        // 设置服务器session的超时时长为10分钟
        session.setTimeout(Duration.ofMinutes(10));
        factory.setSession(session);
        // 设置404的错误页面
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notfound.html"));
        // 设置该服务器的context path
        factory.setContextPath("/newtest");
        Compression compression=new Compression();
        compression.setMinResponseSize(DataSize.ofBytes(1024));
        // 设置开启HTTP响应压缩
        factory.setCompression(compression);
        return factory;
    }
}
