package com.jackson.utils;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

public class WebApplicationContextUtils {

    public static ApplicationContext getWebApplicationContext(ServletContext servletContext) {
        return (ApplicationContext) servletContext.getAttribute("app");
    }
}
