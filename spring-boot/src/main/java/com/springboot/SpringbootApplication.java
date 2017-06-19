package com.springboot;

import com.springboot.javabean.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path spring-boot/com.springboot.controller
 * @date 2017/6/18 上午10:42
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@RestController
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@ImportResource({"classpath:backup-context.xml"})
public class SpringbootApplication {

    //@Autowired
    //Author author ;
    //@RequestMapping("/")
    //String index(){
        //return "welcome to spring boot,my name is "+author.getName() ;
    //}
    //public static void main(String[] args){
        //SpringApplication.run(SpringbootApplication.class,args) ;
   // }
}
