package com.springboot.service.aop.impl;

import com.springboot.annotation.Action;
import org.springframework.stereotype.Service;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path spring-boot/com.springboot.service.aop
 * @date 2017/4/20 上午11:42
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Service("loginService")
public class LoginServiceImpl{

    /**
     * @param username
     * @param password
     */
    @Action(name="登录")
    public void login(String username, String password) {
        System.out.println("login....");
    }
}
