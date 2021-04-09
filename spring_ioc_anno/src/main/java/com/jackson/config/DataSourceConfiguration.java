package com.jackson.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.beans.PropertyVetoException;

@PropertySource(value = "classpath:jdbc.properties")   // 加載jdbc.properties <context:property-placeholder location="classpath:jdbc.properties"/>
public class DataSourceConfiguration {
    @Value(value = "${jdbc.driver}")
    String driver;

    @Value(value = "${jdbc.url}")
    String url;

    @Value(value = "${jdbc.username}")
    String username;

    @Value(value = "${jdbc.password}")
    String password;

    @Bean(value = "c3p0")   // 將當前方法的返回值 以指定名稱 注冊到SpringIOC容器中
    public ComboPooledDataSource getDataSource() throws PropertyVetoException {
        // <bean id="c3p0" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        ComboPooledDataSource c3p0 = new ComboPooledDataSource();

        c3p0.setDriverClass(driver);
        c3p0.setJdbcUrl(url);
        c3p0.setUser(username);
        c3p0.setPassword(password);

        return c3p0;
    }
}
