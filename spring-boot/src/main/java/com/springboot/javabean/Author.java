package com.springboot.javabean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path spring-boot/com.springboot.javabean
 * @date 2017/6/18 下午1:10
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Component
@ConfigurationProperties(prefix = "author")
//,locations={"classpath:config/author.properties"}
public class Author {

    private String name ;
    private String age ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
