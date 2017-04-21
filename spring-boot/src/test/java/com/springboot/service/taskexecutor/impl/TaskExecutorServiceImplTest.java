package com.springboot.service.taskexecutor.impl;

import com.springboot.annotation.TaskExecutor;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path spring-boot/com.springboot.service.taskexecutor.impl
 * @date 2017/4/21 下午8:42
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class TaskExecutorServiceImplTest {
    @Test
    public  void testTaskExecutor(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(TaskExecutor.class) ;
        TaskExecutorServiceImpl taskExecutorService = context.getBean(TaskExecutorServiceImpl.class) ;
        for(int i=0;i<10;i++){
            taskExecutorService.executeAsyncTask(i);
            taskExecutorService.executeAsyncTaskPlusOne(i);
        }
        context.close();
    }
}
