package com.hsy.springboot.jdbc.service;

import com.hsy.springboot.demo.springboot.jdbc.bean.entity.TProvince;

import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot.demo/com.hsy.springboot.demo.springboot.jdbc.service
 * @date 24/10/2017 7:48 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public interface ITProvinceService {
    List<TProvince> listTProvince() ;
    TProvince getById(String id) ;
}
