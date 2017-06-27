package com.hsy.springbootdemo.javabean.protocolbean ;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.sql.Time;

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
public class Author {

    private String name ;
    private String sex ;
    private Time times;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public Time getTimes() {
        return times;
    }

    public void setTimes(Time times) {
        this.times = times;
    }
}