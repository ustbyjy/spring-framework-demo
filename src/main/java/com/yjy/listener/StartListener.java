package com.yjy.listener;

import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

public class StartListener extends ContextLoaderListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        event.getServletContext().setInitParameter(CONFIG_LOCATION_PARAM, "file:D:/IdeaProjects/spring-framework-demo/config/applicationContext.xml");
        super.contextInitialized(event);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        super.contextDestroyed(event);
    }

}
