package com.jackson.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        // 0. 讀取web.xml中的全局參數
        String contextConfigLocation = servletContext.getInitParameter("ContextConfigLocation");

        // 1. 加載Spring配置文件，初始化Spring容器
        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);

        // 2. 將ApplicationContext對象存儲到ServletContext域中

        servletContext.setAttribute("app", app);

        System.out.println("Spring 容器創建完畢....");
    }

}
