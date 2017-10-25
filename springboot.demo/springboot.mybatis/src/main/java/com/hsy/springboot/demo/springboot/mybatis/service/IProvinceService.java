package com.hsy.springboot.demo.springboot.mybatis.service;

import com.hsy.springboot.demo.springboot.mybatis.bean.entity.TProvince;

import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot.demo/com.hsy.springboot.demo.springboot.mybatis.service
 * @date 25/10/2017 9:30 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public interface IProvinceService {
    List<TProvince> getProvinceList();
    TProvince getProvinceById(String id) ;
}
