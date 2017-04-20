package com.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path spring-boot/com.springboot.aop
 * @date 2017/4/8 下午3:09
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Aspect
public class LogAspectJ {

    @Pointcut("@annotation(com.springboot.aop.Action)")
    public void annotationPointCut(){}

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint){
        MethodSignature signation = (MethodSignature) joinPoint.getSignature() ;
        Method method = signation.getMethod() ;
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截 " + action.name()) ;
    }

    @Before("execution(* com.springboot.service.aop.impl.test*(..))")
    public void before(JoinPoint joinPoint){
        MethodSignature signation = (MethodSignature) joinPoint.getSignature() ;
        Method method = signation.getMethod() ;
        Action action = method.getAnnotation(Action.class);
        System.out.println("方法规则式拦截 " + method.getName()) ;
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


}
