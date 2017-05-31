package com.springboot.service.taskexecutor.impl;

import com.springboot.config.SpringWebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path spring-boot/com.springboot.service.taskexecutor.impl
 * @date 2017/4/21 下午8:42
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringWebApplication.class}) //加载配置
public class TaskExecutorServiceImplTest {
    @Autowired
    private TaskExecutorServiceImpl taskExecutorService ;
    @Test
    public  void testTaskExecutor(){
        for(int i=0;i<10;i++){
            taskExecutorService.executeAsyncTask(i);
            taskExecutorService.executeAsyncTaskPlusOne(i);
        }
    }
}
