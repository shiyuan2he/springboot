package com.springboot.aop;

import com.springboot.annotation.Action;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author heshiyuan
 * @description <p>日志输出</p>
 * @path spring-boot/com.springboot.aop
 * @date 2017/4/8 下午3:09
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Aspect
@Component
public class LogAspectJ {

    long start = 0,end = 0; ;
    @Pointcut("@annotation(com.springboot.annotation.Action)")
    public void annotationPointCut(){}
    /**
     * @description <p>调用接口方法前调用</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 2017/5/18 下午1:21
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    @Before("annotationPointCut()")
    public void beforeInvokeInterface(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        System.out.println(Thread.currentThread().getId()+":调用"+signature.getName()+"接口开始...") ;
        start = System.currentTimeMillis() ;
    }
    /**
     * @description <p>通过自定义注解拦截</p>
     * @param joinPoint
     * @author heshiyuan
     * @date 2017/5/18 下午12:22
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    @After("annotationPointCut()")
    public void afterInvokeInterface(JoinPoint joinPoint){
        MethodSignature signation = (MethodSignature) joinPoint.getSignature() ;
        Method method = signation.getMethod() ;
        Action action = method.getAnnotation(Action.class);
        System.out.println(Thread.currentThread().getId()+":调用"+method.getName()+"接口结束...") ;
        end = System.currentTimeMillis() ;
        System.out.println(Thread.currentThread().getId()+"：日志("+action.name()+"),接口耗时"+(end - start)+"ms") ;
    }
    /**
     * @description <p>方法命名式拦截</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 2017/5/18 下午12:22
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    /*@Before("execution(* com.springboot.service.aop.impl.RegisterServiceImpl.*(..))")
    public void before(JoinPoint joinPoint){
        MethodSignature signation = (MethodSignature) joinPoint.getSignature() ;
        Method method = signation.getMethod() ;
        System.out.println("方法规则式拦截 " + method.getName()) ;
    }*/
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


}
