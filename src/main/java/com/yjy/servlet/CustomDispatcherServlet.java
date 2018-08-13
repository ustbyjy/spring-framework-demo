package com.yjy.servlet;

import org.springframework.web.servlet.DispatcherServlet;

public class CustomDispatcherServlet extends DispatcherServlet {
    private static final long serialVersionUID = 4556688394661662171L;

    public CustomDispatcherServlet() {
        super();

        initContextConfigLocation();
    }

    private void initContextConfigLocation() {
        String path;
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            path = "D:/IdeaProjects/spring-framework-demo/config/";
        } else {
            path = System.getProperty("catalina.home") + "/config/";
        }

        super.setContextConfigLocation("file:" + path + "spring-mvc.xml");
    }

}
