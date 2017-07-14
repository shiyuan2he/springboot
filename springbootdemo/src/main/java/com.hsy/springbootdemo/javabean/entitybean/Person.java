package com.hsy.springbootdemo.javabean.entitybean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * @param
 * @author heshiyuan
 * @description <p>hibernate支持自动将实体类映射成为数据库表</p>
 * @date 2017/7/12 11:36
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
@Entity
@NamedQuery(name="Person.withNameAndAddressNamedQuery",query="select p from Person p where p.name = ?1 and p.address = ?2")
public class Person {

    @Id
    @GeneratedValue
    private Long id ;
    private String name ;
    private Integer age ;
    private String address ;

    public Person(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
