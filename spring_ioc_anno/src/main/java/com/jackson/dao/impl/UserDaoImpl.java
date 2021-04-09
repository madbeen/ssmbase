package com.jackson.dao.impl;

import com.jackson.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// @Component(value = "userDao") // 注冊到IOC容器 value=bean id
@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
        //System.out.println("Init UserDaoImpl...");
    }

    public void save() {
        System.out.println("UserDaoImpl save() running...");
    }

    public void init() {
        System.out.println("UserDaoImpl init() running...");
    }

    public void destroy() {
        System.out.println("UserDaoImpl destroy() running...");
    }

}
