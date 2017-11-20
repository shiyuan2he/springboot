package com.hsy.springboot.demo.springboot.config.web;

import com.hsy.springboot.demo.springboot.config.bean.ConfigBean;
import com.hsy.springboot.demo.springboot.config.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description <p>rest风格数据获取</p>
 * @author heshiyuan 
 * @date 24/10/2017 4:48 PM
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
@RestController
@RequestMapping(value="/api/restful/")
@EnableConfigurationProperties({ConfigBean.class,User.class})
public class RestfulController {
    @Autowired
    ConfigBean configBean;

    @RequestMapping(value = "/v1.0/configBean",method = RequestMethod.GET)
    public String beanValue(){
        return configBean.getGreeting()+" >>>>"+configBean.getName()+" >>>>"+ configBean.getUuid()+" >>>>"+configBean.getMax();
    }

    @Autowired
    User user;
    @RequestMapping(value = {"/v1.0/user/list","/users"},method = RequestMethod.GET)
    public String user(){
        return user.getName()+user.getAge();
    }

    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private int age;

    @RequestMapping(value = "/v1.0/my",method = RequestMethod.GET)
    public String dataValue(){
        return name+":"+age;
    }

}
