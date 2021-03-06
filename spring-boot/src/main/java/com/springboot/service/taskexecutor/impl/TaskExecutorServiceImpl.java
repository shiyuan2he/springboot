package com.springboot.service.taskexecutor.impl;

import com.springboot.service.webinit.impl.WebInitializerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path spring-boot/com.springboot.service.taskexecutor.impl
 * @date 2017/4/21 下午8:10
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Service
public class TaskExecutorServiceImpl {
    private static Logger logger = LoggerFactory.getLogger(TaskExecutorServiceImpl.class);
    @Async
    public void executeAsyncTask(Integer i){
        logger.info("异步任务："+i);
    }
    @Async
    public void executeAsyncTaskPlusOne(Integer i){
        logger.info("加强异步任务："+(i+1));
    }
}
