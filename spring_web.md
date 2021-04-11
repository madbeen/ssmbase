# Spring Web

1. 環境搭建 
2. 獲取應用上下文 （ApplicationContext 配置監聽器，服務器一啓動，加載Spring 容器，并將應用上下文對象 存儲到最大的域中 (ServletContext)）
3. 實現 implements ServletContextListener，注冊到Web.xml中
4. spring_web代碼演示實現Spring ContextLoaderListener



# Spring集成web環境 spring-web依賴

1. web.xml中配置contextLoaderListener

```xml
    <!--指定spring核心文件的位置-->
	<context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:applicationContext.xml</param-value>
    </context-param>

	<!--配置監聽器，服務器一啓動，加載Spring 容器，并將應用上下文對象 存儲到最大的域中-->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
```

>如果不特意指定参数名为contextConfigLoction的\<context-parameter>元素，那么spring的ContextLoderListener监听器就会在/WEB-INF/下去寻找并加载该目录下的名为applicationContext.xml这个文件。我们应该在web.xml中添加\<context-param>标签并再次指定spring核心文件的位置

2. 獲取應用上下文 對象

```java
	WebApplicationContextUtils.getWebApplicationContext(servletContext);
```

