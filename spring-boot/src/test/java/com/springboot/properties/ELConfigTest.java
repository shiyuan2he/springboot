package com.springboot.properties;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path spring-boot/com.springboot.properties
 * @date 2017/4/21 上午10:38
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ELConfigTest {

    @Test
    public void testELConfig(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ELConfig.class) ;
        ELConfig elConfig = context.getBean(ELConfig.class) ;
        elConfig.outputResource();
        context.close();
    }
}
