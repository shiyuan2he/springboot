package com.hsy.springbootdemo.controller ;
import com.hsy.springbootdemo.javabean.protocolbean.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path spring/controller
 * @date 2017/6/27 16:01
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@RestController
public class RestfulController {

    @Autowired
    Author author ;
    @RequestMapping("/restful")
    public String getData(){
        return "hello spring boot world,my name is "+ author.getName();
    }
}
