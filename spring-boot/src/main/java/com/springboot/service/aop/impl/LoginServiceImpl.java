package com.springboot.service.aop.impl;

import com.springboot.aop.Action;
import com.springboot.service.aop.ILoginService;

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
public class LoginServiceImpl implements ILoginService{

    /**
     * @param username
     * @param password
     */
    @Action(name="登录")
    @Override
    public void login(String username, String password) {
        System.out.println("login....");
    }

    @Override
    public void testLogin(String username, String password) {
        System.out.println("test login...");
    }


}
