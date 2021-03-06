package com.springboot.service.beanway.impl;

import com.springboot.config.SpringWebApplication;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path spring-boot/com.springboot.service.beanway.impl
 * @date 2017/4/21 下午4:43
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class BeanWayServiceImplTest {
    @Test
    public void testCreateBeanWay(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringWebApplication.class) ;
        context.close();
    }
}
