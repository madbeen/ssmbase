package com.jackson.ioc;

import com.jackson.dao.UserDao;
import com.jackson.domain.User;
import com.jackson.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocTest {
    @Test
    public void iocGetBean() {
        // 加載Spring核心配置文件
        ApplicationContext app = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        // 獲取交由SpringIoc容器管理的類（bean）
        // 第一個參數為配置文件中向IOC容器注冊的bean的id
        UserDao userDao = app.getBean("userDao", UserDao.class);

        userDao.save();
    }

    @Test
    public void iocGetBeanScopeParam() {
        ApplicationContext app = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        // scope = singleton getBean獲取到的是同一個對象
        UserDao userDaoSingleton1 = app.getBean("userDaoSingleton", UserDao.class);
        UserDao userDaoSingleton2 = app.getBean("userDaoSingleton", UserDao.class);
        UserDao userDaoSingleton3 = app.getBean("userDaoSingleton", UserDao.class);

        System.out.println("userDaoSingleton1 = " + userDaoSingleton1);
        System.out.println("userDaoSingleton2 = " + userDaoSingleton2);
        System.out.println("userDaoSingleton3 = " + userDaoSingleton3);

        System.out.println("------------------------------------------------");

        // scope = prototype
        UserDao userDaoPrototype1 = app.getBean("userDaoPrototype", UserDao.class);
        UserDao userDaoPrototype2 = app.getBean("userDaoPrototype", UserDao.class);
        UserDao userDaoPrototype3 = app.getBean("userDaoPrototype", UserDao.class);

        System.out.println("userDaoPrototype3 = " + userDaoPrototype1);
        System.out.println("userDaoPrototype2 = " + userDaoPrototype2);
        System.out.println("userDaoPrototype3 = " + userDaoPrototype3);
    }

    @Test
    public void iocBeanScope() {
        // 配置一加載、創建Spring容器時，Singleton Bean即創建，容器銷毀時Singleton bean銷毀
        ApplicationContext app = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        // Prototype Bean 調用GetBean時，PrototypeBean 創建，未被使用時由GC回收
        UserDao userDaoPrototype = app.getBean("userDaoPrototype", UserDao.class);
    }

    @Test
    public void iocBeanInitDestroy() {
        ApplicationContext app = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        UserDao userDao = app.getBean("userDaoInitDestroy", UserDao.class);

        ((ClassPathXmlApplicationContext) app).close();
    }

    @Test
    public void iocBeanStaticFactory() {
        ApplicationContext app = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        UserDao userDao = app.getBean("userDaoStatic", UserDao.class);

        System.out.println("userDao = " + userDao);
        userDao.save();
    }

    @Test
    public void iocBeanDynamicFactory() {
        ApplicationContext app = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        UserDao userDao = app.getBean("userDaoDynamic", UserDao.class);

        System.out.println("userDao = " + userDao);
        userDao.save();
    }

    @Test
    public void iocBeanService() {
        ApplicationContext app = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        UserService userService = app.getBean("userService", UserService.class);

        System.out.println("userService = " + userService);
        userService.save();
    }

    @Test
    public void beanDI() {
        ApplicationContext app = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        User user = app.getBean("user", User.class);

        System.out.println("user = " + user);
    }
}
