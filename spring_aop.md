# AOP

- Target（目标对象）：代理的目标对象
- Proxy（代理）：一个类被AOP织入增强后，产生一个代理类
- Joinpoint（连接点）：被拦截的点，在spring中指方法
- Pointcut（切入点）：对哪些 Joinpoint进行拦截的定义 ，被增强的方法
- Advice（通知/增强）：拦截到Joinpoint之后所要做的事
- Aspect（切面）：切入点和通知的结合



1. 导入依赖
2. 创建目标接口和目标类
3. 编写切面类，切面类有增强功能方法（通知）
4. 将目标类和切面类注册到Spring容器中
5. 在配置文件中配置织入关系，即将哪些通知与哪些连接点进行结合

```xml
    <!--目标对象-->
    <bean id="target" class="com.jackson.aop.impl.TargetImpl"/>

    <!--切面对象-->
    <bean id="myAspect" class="com.jackson.aop.MyAspect"/>

    <!--织入: 告诉Spring，哪些方法需要哪些增强-->
    <aop:config>
        <!--切面：切点+通知-->
        <aop:aspect ref="myAspect">
<!--            <aop:before method="beforeAdvice" pointcut="execution(* com.jackson.aop.impl.*(..))"/>-->
            <aop:around method="aroundAdvice" pointcut="execution(* com.jackson.aop.impl.*.*(..))"/>
        </aop:aspect>
    </aop:config>
```



## 切点表达式抽取

```xml
            <!--抽取切点表达式-->
            <aop:pointcut id="myPointcut" expression="execution(* com.jackson.aop.impl.*.*(..))"/>
<!--            <aop:before method="beforeAdvice" pointcut="execution(* com.jackson.aop.impl.*(..))"/>-->
            <aop:around method="aroundAdvice" pointcut-ref="myPointcut"/>
```



## 注解开发

1. 导入依赖
2. 创建目标接口和目标类
3. 编写切面类，切面类有增强功能方法（通知）
4. 将目标类和切面类注册到Spring容器中
5. 在配置文件中配置织入关系，即将哪些通知与哪些连接点进行结合
6. 在配置文件中开启组件扫描和AOP自动代理