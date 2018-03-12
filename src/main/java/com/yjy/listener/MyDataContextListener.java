package com.yjy.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyDataContextListener implements ServletContextListener {
    private ServletContext context = null;

    public MyDataContextListener() {
    }

    @Override

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("MyDataContextListener init...");
        this.context = sce.getServletContext();
        context.setAttribute("myData", "this is myData");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("MyDataContextListener destroy...");
        this.context = null;
    }
}
