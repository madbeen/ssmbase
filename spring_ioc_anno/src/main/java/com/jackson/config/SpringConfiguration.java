package com.jackson.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.beans.PropertyVetoException;


@Configuration  // 標志 表明該類為Spring的核心配置類 == applicationContext.xml
@Component(value = "com.jackson")   // 組件掃描 == <context:component-scan base-package="com.jackson"/>
@Import(DataSourceConfiguration.class) // <import resource="classpath:spring/applicationContext-*.xml"/>
public class SpringConfiguration {

}
