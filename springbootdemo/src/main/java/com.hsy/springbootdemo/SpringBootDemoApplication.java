package com.hsy.springbootdemo;

import com.hsy.springbootdemo.javabean.protocolbean.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path spring/PACKAGE_NAME
 * @date 2017/6/27 15:22
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@RestController
@SpringBootApplication
//@ImportResource({"classpath:application-context.xml"})
public class SpringBootDemoApplication {
    @Autowired
    Author author ;
    @RequestMapping("/")
    public String getData(){
        return "hello spring boot world"+author.getName() + author.getTimes();
    }
    public static void main(String[] args){
        SpringApplication.run(SpringBootDemoApplication.class,args);
    }
}
