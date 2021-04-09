package com.jackson.anno;

import com.jackson.config.SpringConfiguration;
import com.jackson.service.UserService;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {
    @Test
    public void annotation() {
        // 1. 使用注解注冊bean @Component
        // 2. 使用@Autowired + @Qualifier(beanId) 注解注入屬性
        // 3. 在Spring核心配置文件中配置組件掃描 context:component-scan
        ApplicationContext app = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        UserService userService = app.getBean("userService", UserService.class);
        userService.save();

        ((ClassPathXmlApplicationContext) app).close();
    }

    @Test
    public void dataSourceAnnotation() {
        // 1. @Configuration  // 標志 表明該類為Spring的核心配置類 == applicationContext.xml
        // 2. @Component(value = "com.jackson")   // 組件掃描 == <context:component-scan base-package="com.jackson"/>
        // 3. @PropertySource(value = "classpath:jdbc.properties")   // 加載jdbc.properties <context:property-placeholder location="classpath:jdbc.properties"/>
        // 4. @Value(value = "${jdbc.driver}") ... url username password
        // 5. @Bean(value = "c3p0")   // 將當前方法的返回值 以指定名稱 注冊到SpringIOC容器中

        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        ComboPooledDataSource c3p0 = app.getBean("c3p0", ComboPooledDataSource.class);

        System.out.println("c3p0 = " + c3p0);
    }
}
