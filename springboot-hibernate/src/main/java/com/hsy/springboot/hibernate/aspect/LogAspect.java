package com.hsy.springboot.hibernate.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot.demo/com.hsy.springboot.demo.jpa.aspect
 * @date 25/10/2017 5:44 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Aspect
@Component
public class LogAspect {
    private final static Logger _logger = LoggerFactory.getLogger(LogAspect.class) ;
    @Pointcut("execution(public * com.hsy.springboot.demo.jpa.web.*.*(..))")
    public void logAspect(){}

    @Before("logAspect()")
    public void doBefore(JoinPoint joinPoint){
        _logger.info("【切面日志】调用方法前。。");

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes() ;
        HttpServletRequest request = attributes.getRequest() ;
        // url
        _logger.info("url={}",request.getRequestURL());
        // method
        _logger.info("method={}",request.getMethod());
        // ip
        _logger.info("ip={}",request.getRemoteAddr());
        // 类名，方法
        _logger.info("class_method={}.{}",joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature().getName());
        // 参数
        _logger.info("args={}",joinPoint.getArgs());
    }

    @After("logAspect()")
    public void doAfter(){
        _logger.info("【切面日志】调用方法后。。");
    }
}
