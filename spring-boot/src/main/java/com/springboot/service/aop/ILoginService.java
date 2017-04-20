package com.springboot.service.aop;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path spring-boot/com.springboot.service.aop
 * @date 2017/4/20 上午11:41
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public interface ILoginService {
    /**
     * @param username
     * @param password
     * @description 模拟登陆功能
     */
    void login(String username, String password) ;

    void testLogin(String username, String password) ;
}
