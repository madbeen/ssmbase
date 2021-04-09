package com.jackson.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataSourceTest {
    @Test
    public void dataSource() throws Exception {
        // 創建數據源
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        // 設置數據源連接參數
//        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
//        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false");
//        dataSource.setUser("root");
//        dataSource.setPassword("root");

        // 抽取連接參數 加載jdbc.properties,後期可直接在xml中配置
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        String driver = resourceBundle.getString("jdbc.driver");
        String url = resourceBundle.getString("jdbc.url");
        String username = resourceBundle.getString("jdbc.username");
        String password = resourceBundle.getString("jdbc.password");

        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);



        // 獲取資源
        Connection connection = dataSource.getConnection();

        System.out.println("connection = " + connection);

        // 歸還到數據源中
        connection.close();
    }

    @Test
    public void springDataSource() throws SQLException {
        ApplicationContext app = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        ComboPooledDataSource c3p0 = app.getBean("c3p0", ComboPooledDataSource.class);
        Connection connection = c3p0.getConnection();

        System.out.println("connection = " + connection);

        connection.close();
    }
}
