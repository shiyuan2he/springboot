package com.springboot.service.applicationevent.impl;

import com.springboot.config.ConfigProperties;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path spring-boot/com.springboot.service.applicationevent.impl
 * @date 2017/4/21 下午5:56
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ApplicationEventServiceImplTest {

    @Test
    public void testApplicationEvnet(){
         AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigProperties.class) ;
        CustomApplicationPublisherServiceImpl customApplicationPublisherService = context.getBean(CustomApplicationPublisherServiceImpl.class) ;
        customApplicationPublisherService.publish("我发布了一条消息。。。");
        context.close();
    }
}
