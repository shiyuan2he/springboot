package com.springboot.controller;

import com.springboot.javabean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path spring-boot/com.springboot.controller
 * @date 2017/6/11 上午11:23
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
//
@RestController
@RequestMapping("/rest")
public class RestFulController {

    //直接返回对象，对象会自动转化成json
    @RequestMapping(value="/getJson",produces={"application/json;charset=UTF-8"})
    public User getJson(User user){
        return new User(user.getId(),user.getName(),user.getCardNo()) ;
    }
    //直接返回对象，对象会自动转化成xml
    @RequestMapping(value="/getXml",produces={"application/xml;charset=UTF-8"})
    public User getXml(User user){
        return new User(user.getId(),user.getName(),user.getCardNo()) ;
    }
}