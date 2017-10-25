package com.hsy.springboot.demo.springboot.mybatis.service.impl;

import com.hsy.springboot.demo.springboot.mybatis.bean.entity.TProvince;
import com.hsy.springboot.demo.springboot.mybatis.mapper.TProvinceMapper;
import com.hsy.springboot.demo.springboot.mybatis.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot.demo/com.hsy.springboot.demo.springboot.mybatis.service.impl
 * @date 25/10/2017 9:31 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Service("provinceService")
public class ProvinceServiceImpl implements IProvinceService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    TProvinceMapper tProvinceMapper ;
    @Override
    public List<TProvince> getProvinceList() {
        //return tProvinceMapper.getProvinceList();
        return null ;
    }

    @Override
    public TProvince getProvinceById(String id) {
        //return tProvinceMapper.getProvinceById(id);
        return null ;
    }
}
