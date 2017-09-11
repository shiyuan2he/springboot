package com.hsy.springbootdemo.javabean.modelbean;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path spring/com.hsy.springbootdemo.javabean.modelbean
 * @date 2017/7/4 下午9:38
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class Person {
    private String name ;
    private Integer age ;

    public Person(Integer age,String name) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
