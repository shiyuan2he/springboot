package com.springboot.aop;

import com.springboot.annotation.ActionLog;
import com.springboot.service.taskexecutor.impl.TaskExecutorServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

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
@Aspect //申明是一个切面
@Component
public class LogAspectJ {
    private static Logger logger = LoggerFactory.getLogger(TaskExecutorServiceImpl.class);
    long start = 0,end = 0;
    @Pointcut("@annotation(com.springboot.annotation.ActionLog)")
    public void annotationPointCut(){}
    /**
     * @description <p>调用接口方法前调用</p>
     * @param   joinPoint
     * @author heshiyuan
     * @date 2017/5/18 下午1:21
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    @Before("annotationPointCut()")
    public void beforeInvokeInterface(JoinPoint joinPoint){
        MethodSignature signation = (MethodSignature) joinPoint.getSignature() ;
        Method method = signation.getMethod() ;
        Object[] args = joinPoint.getArgs();
        logger.info(Thread.currentThread().getId()+":调用"+method.getName()+"接口开始...参数："+ Arrays.asList(args)) ;
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
        ActionLog action = method.getAnnotation(ActionLog.class);
        logger.info(Thread.currentThread().getId()+":调用"+method.getName()+"接口结束...") ;
        end = System.currentTimeMillis() ;
        logger.info(Thread.currentThread().getId()+"：日志("+action.description()+"),接口耗时"+(end - start)+"ms") ;
    }
    /**
     * @description <p>方法命名式拦截</p>
     * @param
     * @author heshiyuan
     * @date 2017/5/18 下午12:22
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    @Before("execution(* com.springboot.controller.*(..))")
    public void before(JoinPoint joinPoint){
        MethodSignature signation = (MethodSignature) joinPoint.getSignature() ;
        Method method = signation.getMethod() ;
        logger.info("方法规则式拦截 " + method.getName()) ;
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


}
