package com.springboot.service.applicationevent.impl;

import org.springframework.context.ApplicationEvent;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path spring-boot/com.springboot.service.actionevent.impl
 * @date 2017/4/21 下午5:43
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class CustomApplicationEventServiceImpl extends ApplicationEvent{

    private String msg ;
    public CustomApplicationEventServiceImpl(Object source,String msg) {
        super(source);
        this.msg = msg ;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
