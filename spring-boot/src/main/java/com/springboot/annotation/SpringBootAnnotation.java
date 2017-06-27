package com.springboot.annotation;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.lang.annotation.*;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p>组合注解</p>
 * @path spring-boot/com.springboot.annotation
 * @date 2017/4/25 下午8:18
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration  //元注解
@EnableWebMvc
//@EnableAspectJAutoProxy() //aop自动代理
@EnableScheduling//开启对计划任务的支持
@EnableAsync //开启异步多线程方法调用
@EnableAutoConfiguration
@ComponentScan("com.springboot")
public @interface SpringBootAnnotation {
    String[] value() default {} ;
}
