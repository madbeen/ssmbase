package com.jackson.factory;

import com.jackson.dao.UserDao;
import com.jackson.dao.impl.UserDaoImpl;

public class StaticFactory {
    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
