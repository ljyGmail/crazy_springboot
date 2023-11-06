package com.crazyit.firstboot.app.config;

import com.crazyit.firstboot.app.web.CrazyitFilter;
import com.crazyit.firstboot.app.web.CrazyitListener;
import com.crazyit.firstboot.app.web.FirstServlet;
import com.crazyit.firstboot.app.web.SecondServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ServletRegistrationBean<FirstServlet> createServlet1() {
        FirstServlet firstServlet = new FirstServlet();
        // 注册Servlet
        ServletRegistrationBean<FirstServlet> registrationBean = new ServletRegistrationBean<>(firstServlet, "/first");
        return registrationBean;
    }

    @Bean
    public ServletRegistrationBean<SecondServlet> createServlet2() {
        SecondServlet secondServlet = new SecondServlet();
        // 注册Servlet
        ServletRegistrationBean<SecondServlet> registrationBean = new ServletRegistrationBean<>(secondServlet, "/second");
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<CrazyitListener> createListener() {
        CrazyitListener listener = new CrazyitListener();
        // 注册Listener
        ServletListenerRegistrationBean<CrazyitListener> registrationBean = new ServletListenerRegistrationBean<>(listener);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<CrazyitFilter> createFilter() {
        CrazyitFilter filter = new CrazyitFilter();
        // 注册Filter
        FilterRegistrationBean<CrazyitFilter> registrationBean = new FilterRegistrationBean<>(filter);
        return registrationBean;
    }
}
