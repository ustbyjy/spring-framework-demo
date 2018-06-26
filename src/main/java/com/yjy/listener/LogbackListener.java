package com.yjy.listener;

import ch.qos.logback.ext.spring.web.WebLogbackConfigurer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class LogbackListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.setProperty("customSystemProperty", "xxx");

        WebLogbackConfigurer.initLogging(sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        WebLogbackConfigurer.shutdownLogging(sce.getServletContext());
    }
}
