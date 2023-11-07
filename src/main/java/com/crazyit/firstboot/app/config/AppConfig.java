package com.crazyit.firstboot.app.config;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// 通过该注解设置到指定包中扫描Servlet, Filter, Listener
@ServletComponentScan("com.crazyit.firstboot.app.web")
public class AppConfig {
}
