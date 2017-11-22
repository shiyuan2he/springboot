package com.hsy.springboot.jdbc.service.impl;

import com.hsy.springboot.demo.springboot.jdbc.bean.entity.TProvince;
import com.hsy.springboot.demo.springboot.jdbc.dao.ITProvinceDao;
import com.hsy.springboot.demo.springboot.jdbc.service.ITProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot.demo/com.hsy.springboot.demo.springboot.jdbc.service.impl
 * @date 24/10/2017 7:49 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Service("provinceService")
public class ProvinceServiceImpl implements ITProvinceService{
    @Autowired
    ITProvinceDao provinceDao ;
    @Override
    public List<TProvince> listTProvince() {
        return provinceDao.getTProvinceList();
    }

    @Override
    public TProvince getById(String id) {
        return provinceDao.getTProvinceById(id);
    }
}
