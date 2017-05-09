package com.springboot.service.aop.impl;

import org.springframework.stereotype.Service;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path spring-boot/com.springboot.service.aop.impl
 * @date 2017/4/20 下午7:50
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Service("registerService")
public class RegisterServiceImpl{
    public void testLogin(String username, String password) {
        System.out.println("test register");
    }
}
