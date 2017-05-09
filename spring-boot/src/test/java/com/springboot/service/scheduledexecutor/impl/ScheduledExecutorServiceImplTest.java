package com.springboot.service.scheduledexecutor.impl;

import com.springboot.config.ScheduledExecutor;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path spring-boot/com.springboot.service.scheduledexecutor.impl
 * @date 2017/4/21 下午11:16
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ScheduledExecutorServiceImplTest {

    @Test
    public void testScheduledExecutor(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScheduledExecutor.class) ;
    }
}
