package com.jackson.service.impl;

import com.jackson.dao.UserDao;
import com.jackson.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


//@Component(value = "userService")
@Service(value = "userService")
@Scope(value = "singleton")
public class UserServiceImpl implements UserService {
    @Value("${jdbc.driver}")    // <context:property-placeholder location="classpath:jdbc.properties"/>
    private String driver; // 普通屬性的注入

    // 注解注入通過反射對屬性賦值
    @Autowired  //自動注入 按照數據類型 從Spring容器中匹配類型為UserDao的bean，若是有多個類型為UserDao的bean則需要加Qualifier匹配bean id
    @Qualifier("userDao")   // 依賴注入，已注冊bean的Id，從Spring容器中匹配bean id
    // @Resource("userDao") // 相當於 Autowired+Qualifier(bean id)
    private UserDao userDao;

    public void save() {
        ApplicationContext app = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        //UserDao userDao = app.getBean("userDao", UserDao.class);

        userDao.save();

        System.out.println("UserServiceImpl save() running...");

        System.out.println("普通屬性注入 @Value() driver = " + driver);
    }

    @PostConstruct
    public void initMethod() {
        System.out.println("UserServiceImpl Init()");
    }

    @PreDestroy
    public void destroyMethod() {
        System.out.println("UserServiceImpl Destroy()");
    }


    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
