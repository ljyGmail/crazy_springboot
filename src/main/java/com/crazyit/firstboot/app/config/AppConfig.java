package com.crazyit.firstboot.app.config;

import com.crazyit.firstboot.app.web.CrazyitFilter;
import com.crazyit.firstboot.app.web.CrazyitListener;
import com.crazyit.firstboot.app.web.FirstServlet;
import com.crazyit.firstboot.app.web.SecondServlet;
import jakarta.servlet.Filter;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.http.HttpServlet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean("first")
    public HttpServlet createServlet1() {
        FirstServlet firstServlet = new FirstServlet();
        return firstServlet;
    }

    @Bean("second")
    public HttpServlet createServlet2() {
        SecondServlet secondServlet = new SecondServlet();
        return secondServlet;
    }

    @Bean
    public ServletContextListener createListener() {
        CrazyitListener listener = new CrazyitListener();
        return listener;
    }

    @Bean
    public Filter createFilter() {
        CrazyitFilter filter = new CrazyitFilter();
        return filter;
    }
}
