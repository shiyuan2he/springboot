package com.springboot.service.conditional.impl;

import com.springboot.config.ConfigProperties;
import com.springboot.service.conditional.IListService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path spring-boot/com.springboot.service.conditional.impl
 * @date 2017/4/24 下午12:51
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ConditionServiceImplTest {
    @Test
    public void testContional(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigProperties.class) ;
        IListService IListService = context.getBean(IListService.class) ;
        System.out.println(IListService.showCmd());
        context.close();
    }
}
