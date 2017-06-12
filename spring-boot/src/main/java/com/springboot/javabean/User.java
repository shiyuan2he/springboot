package com.springboot.javabean;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path spring-boot/com.springboot.javabean
 * @date 2017/6/11 上午11:13
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class User {
    private String id ;
    private String name ;
    private String cardNo ;

    public User(String id, String name, String cardNo) {
        this.id = id;
        this.name = name;
        this.cardNo = cardNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}
