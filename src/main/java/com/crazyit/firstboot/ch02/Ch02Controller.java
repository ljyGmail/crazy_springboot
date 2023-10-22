package com.crazyit.firstboot.ch02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("ch02")
public class Ch02Controller {
    // 使用@Value注解访问配置属性
    @Value("${app.java.version}")
    private String javaVersion;
    @Value("${app.sourceEncoding}")
    private String sourceEncoding;
    @Value("${app.name}")
    private String appName;
    @Value("${app.version}")
    private String appVersion;

    @GetMapping("readBuildFileInfo")
    public Map<String, String> readBuildFileInfo() {
        return Map.of("javaVersion", javaVersion,
                "sourceEncoding", sourceEncoding,
                "appName", appName,
                "appVersion", appVersion);
    }
}
