package com.yjy.listener;

import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

public class CustomContextLoaderListener extends ContextLoaderListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        initContextConfigLocation(event.getServletContext());
        super.contextInitialized(event);
    }

    private void initContextConfigLocation(ServletContext context) {
        context.setInitParameter(CONFIG_LOCATION_PARAM, "file:D:/IdeaProjects/spring-framework-demo/config/applicationContext.xml");
    }

}
