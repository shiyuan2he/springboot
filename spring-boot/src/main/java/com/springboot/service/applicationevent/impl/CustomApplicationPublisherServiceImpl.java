package com.springboot.service.applicationevent.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path spring-boot/com.springboot.service.actionevent.impl
 * @date 2017/4/21 下午5:51
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Service
public class CustomApplicationPublisherServiceImpl {
    @Autowired
    private ApplicationContext applicationContext ;

    public void publish(String msg){
        applicationContext.publishEvent(new CustomApplicationEventServiceImpl(this,msg));
    }
}
