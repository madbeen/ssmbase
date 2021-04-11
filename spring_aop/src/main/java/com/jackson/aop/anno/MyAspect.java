package com.jackson.aop.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component(value = "myAspect")
@Aspect // 标注当前类为切面类
public class MyAspect {
    @Pointcut(value = "execution(* com.jackson.aop.anno.impl.*.*(..))")
    public void pointcut() {}

    @Before(value = "pointcut()") // 配置前置增强
    public void beforeAdvice() {
        System.out.println("前置方法...");
    }


    // 环绕增强
    @Around(value = "pointcut()")   // 配置环绕增强
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前增强...");

        Object proceed = joinPoint.proceed();

        System.out.println("环绕后增强...");

        return proceed;
    }
}
