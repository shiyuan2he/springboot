package com.springboot.service.beanway.impl;

import org.springframework.stereotype.Service;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p>bean配置方式初始化bean与销毁bean</p>
 * @path spring-boot/com.springboot.service.beanway.impl
 * @date 2017/4/21 上午11:44
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
//@Service
public class BeanWayServiceImpl {

    public void init(){
        System.out.println("beanway init...");
    }
    public BeanWayServiceImpl(){
        super();
        System.out.println("BeanWayServiceImpl 初始化构造函数...");
    }
    public void destory(){
        System.out.println("beanway destory...");
    }
}
