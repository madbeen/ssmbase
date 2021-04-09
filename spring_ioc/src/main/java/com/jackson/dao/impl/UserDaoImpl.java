package com.jackson.dao.impl;

import com.jackson.dao.UserDao;

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
