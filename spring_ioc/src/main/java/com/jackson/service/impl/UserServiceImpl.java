package com.jackson.service.impl;

import com.jackson.dao.UserDao;
import com.jackson.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {

    private UserDao userDao;


    public void save() {
        ApplicationContext app = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        //UserDao userDao = app.getBean("userDao", UserDao.class);

        userDao.save();

        System.out.println("UserServiceImpl save() running...");
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
