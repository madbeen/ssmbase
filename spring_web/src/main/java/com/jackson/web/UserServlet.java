package com.jackson.web;

import com.jackson.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();

        /**
         * 自定義獲取應用上下文對象
         */
        /*
            //ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");



            //ApplicationContext app = (ApplicationContext) servletContext.getAttribute("app");

            ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        */

        /**
         * spring-web 獲取應用上下文對象
         */
        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        UserService userService = app.getBean("userService", UserService.class);

        userService.save();
    }
}
