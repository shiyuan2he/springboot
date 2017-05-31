package com.springboot.service.webinit.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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
@Service
public class WebInitializerServiceImpl {
    private static Logger logger = LoggerFactory.getLogger(WebInitializerServiceImpl.class);
    public WebInitializerServiceImpl(){
        super();
        logger.info("BeanWayServiceImpl 初始化构造函数...");
    }
    /**
     * @description <p>在构造函数执行完之后执行</p>
     */
    @PostConstruct
    public void initApp(){
        logger.info("注解初始化。。。");
    }

    /**
     * @description <p>在bean销毁之前执行</p>
     */
    @PreDestroy
    public void destoryApp(){
        logger.info("注解销毁。。。");
    }
}
