package com.springboot.service.annotation.impl;/**
 * @description <p></p>
 * @path spring-boot/com.springboot.service.annotation.impl
 * @author heshiyuan
 * @date 2017/4/25 下午8:36
 * @github http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */

import com.springboot.config.ConfigProperties;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description <p></p>
 * @path spring-boot/com.springboot.service.annotation.impl
 * @author heshiyuan
 * @date 2017/4/25 下午8:36
 * @github http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class AnnotationServiceImplTest {
    @Test
    public void testAnnotation(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigProperties.class) ;
        AnnotationServiceImpl annotationServiceImpl = context.getBean(AnnotationServiceImpl.class) ;
        annotationServiceImpl.outputStream();
        context.close();
    }
}
