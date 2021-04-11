package com.jackson.service.impl;

import com.jackson.dao.UserDao;
import com.jackson.service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao;

    public void save() {
        userDao.save();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
