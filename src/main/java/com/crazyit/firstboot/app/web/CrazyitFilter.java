package com.crazyit.firstboot.app.web;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebFilter("/*")
public class CrazyitFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(CrazyitFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOG.info("处理请求之前的过滤处理");
        // 放行请求，继续让目标Servlet(或其他Web组件)处理用户请求
        filterChain.doFilter(servletRequest, servletResponse);
        LOG.info("处理请求之后的过滤处理");
    }
}

