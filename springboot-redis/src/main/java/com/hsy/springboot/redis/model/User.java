package com.hsy.springboot.redis.model;

import java.io.Serializable;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot/com.hsy.springboot.redis.model
 * @date 2017/12/29 9:17
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class User implements Serializable{

    private Long id ;
    private String name ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
