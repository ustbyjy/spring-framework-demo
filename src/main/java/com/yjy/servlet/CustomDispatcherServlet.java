package com.yjy.servlet;

import org.springframework.web.servlet.DispatcherServlet;

public class CustomDispatcherServlet extends DispatcherServlet {
    private static final long serialVersionUID = 4556688394661662171L;

    public CustomDispatcherServlet() {
        super();

        initContextConfigLocation();
    }

    private void initContextConfigLocation() {
        super.setContextConfigLocation("file:D:/IdeaProjects/spring-framework-demo/config/spring-mvc.xml");
    }

}
