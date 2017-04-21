package com.springboot.annotation;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path spring-boot/com.springboot.annotation
 * @date 2017/4/21 下午8:09
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Configuration
@EnableAsync //开启异步任务支持
@ComponentScan("com.springboot.service.taskexecutor.impl")  //定义扫描异步类，异步方法的包
public class TaskExecutor implements AsyncConfigurer{
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecuttor = new ThreadPoolTaskExecutor();
        taskExecuttor.setCorePoolSize(5);
        taskExecuttor.setMaxPoolSize(10);
        taskExecuttor.setQueueCapacity(25);
        taskExecuttor.initialize();
        return taskExecuttor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
