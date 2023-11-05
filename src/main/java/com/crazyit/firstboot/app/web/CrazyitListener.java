package com.crazyit.firstboot.app.web;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CrazyitListener implements ServletContextListener {
    private static final Logger LOG = LoggerFactory.getLogger(CrazyitListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOG.info("-----Web应用初始化完成-----");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOG.info("-----Web应用销毁之前-----");
    }
}
