package com.springboot.service.beanway.impl;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p>JSR250初始化与销毁bean</p>
 * @path spring-boot/com.springboot.service.beanway.impl
 * @date 2017/4/21 上午11:44
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
//@Service
public class JSR250WayServiceImpl {
    public JSR250WayServiceImpl(){
        super();
        System.out.println("JSR250WayServiceImpl 初始化构造函数...");
    }

    /**
     * @description <p>在构造函数执行完之后执行</p>
     */
    @PostConstruct
    public void init(){
        System.out.println("jsr250way init...");
    }

    /**
     * @description <p>在bean销毁之前执行</p>
     */
    @PreDestroy
    public void destory(){
        System.out.println("jsr250way destory...");
    }
}
