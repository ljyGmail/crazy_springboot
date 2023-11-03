package com.crazyit.firstboot.app;

import org.springframework.boot.web.server.Compression;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;

@Component
public class CustomizationBean implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
    @Override
    public void customize(ConfigurableServletWebServerFactory server) {
        // 设置端口
        server.setPort(8081);
        // 设置该服务器的context path
        server.setContextPath("/mytest");
        Compression compression = new Compression();
        compression.setMinResponseSize(DataSize.ofBytes(1024));
        // 设置开启HTTP响应压缩
        server.setCompression(compression);
    }
}
