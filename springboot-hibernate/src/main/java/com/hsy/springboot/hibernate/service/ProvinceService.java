package com.hsy.springboot.hibernate.service;

import com.hsy.springboot.demo.jpa.dao.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot.demo/com.hsy.springboot.demo.jpa.service
 * @date 25/10/2017 4:32 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Service
public class ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository ;

    @Transactional
    public void saveUser(){

    }
}
