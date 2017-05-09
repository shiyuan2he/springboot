package com.springboot.service.aop.impl;

import com.springboot.config.ConfigProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path spring-boot/com.springboot.aop
 * @date 2017/4/20 下午7:16
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigProperties.class})
@ActiveProfiles("prod")
public class LoginServiceTest {
    @Autowired
    LoginServiceImpl loginService ;
    @Autowired
    RegisterServiceImpl registerService ;
    @Test
    public void testLogin(){
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(ConfigProperties.class) ;
//        LoginServiceImpl loginServiceImpl = context.getBean(LoginServiceImpl.class) ;
//        RegisterServiceImpl registerServiceImpl = context.getBean(RegisterServiceImpl.class) ;
//        loginServiceImpl.login("admin","123");
//        registerServiceImpl.testLogin("admin","123");
//        context.close();
          loginService.login("admin","123");
          registerService.testLogin("admin","123");
    }
}
