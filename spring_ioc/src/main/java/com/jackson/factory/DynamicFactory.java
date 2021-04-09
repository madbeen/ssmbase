package com.jackson.factory;

import com.jackson.dao.UserDao;
import com.jackson.dao.impl.UserDaoImpl;

public class DynamicFactory {
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
