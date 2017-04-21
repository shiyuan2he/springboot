package com.springboot.service.applicationevent.impl;

import org.springframework.context.ApplicationListener;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path spring-boot/com.springboot.service.actionevent.impl
 * @date 2017/4/21 下午5:48
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class CustomApplicationListenerServiceImpl implements ApplicationListener<CustomApplicationEventServiceImpl> {
    @Override
    public void onApplicationEvent(CustomApplicationEventServiceImpl customApplicationEventService) {
        String msg = customApplicationEventService.getMsg() ;
        System.out.println("监听到消息："+msg);
    }
}
