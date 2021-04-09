# Spring 注解

實例化Bean

- @Component
- @Controller
- @Service
- @Repository

依賴注入

- @Autowired
- @Qualifier
- @Resource

注入普通屬性

- @Value

Bean作用範圍

- @Scope

InitMethod、DestroyMethod

- @PostConstruct
- @PreDestroy



# Spring注解開發步驟

1. 使用注解注冊bean @Component
2. 使用@Autowired + @Qualifier(beanId) 注解注入屬性(@Qualifier() 注入對象)
3. 在Spring核心配置文件中配置組件掃描 context:component-scan



# Spring新注解

- 非自定義的bean：ComboPoolDataSource
- 加載properties ：\<context:property-placeholder>
- 組件掃描：\<context:component-scan>
- 引入其他文件：\<import>



- @Configuration
- @ComponentScan
- @Bean
- @PropertySource
- @Import