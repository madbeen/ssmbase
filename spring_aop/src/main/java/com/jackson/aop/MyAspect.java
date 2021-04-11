package com.jackson.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
    public void beforeAdvice() {
        System.out.println("前置方法...");
    }


    // 环绕增强
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前增强...");

        Object proceed = joinPoint.proceed();

        System.out.println("环绕后增强...");

        return proceed;
    }
}
