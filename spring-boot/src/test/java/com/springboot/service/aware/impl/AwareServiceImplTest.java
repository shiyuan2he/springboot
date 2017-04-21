package com.springboot.service.aware.impl;

import com.springboot.annotation.ConfigProperties;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path spring-boot/com.springboot.service.aware.impl
 * @date 2017/4/21 下午7:45
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class AwareServiceImplTest {

    @Test
    public void testAwareService(){
         AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigProperties.class) ;
        AwareServiceImpl awareService = context.getBean(AwareServiceImpl.class) ;
        awareService.outputResult();
        context.close();
    }
}
