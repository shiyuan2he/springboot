package com.hsy.springboot.hibernate.web;

import com.hsy.springboot.demo.jpa.dao.ProvinceRepository;
import com.hsy.springboot.demo.jpa.entity.TProvince;
import com.hsy.springboot.demo.jpa.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot.demo/com.hsy.springboot.demo.jpa.web
 * @date 25/10/2017 4:04 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@RestController
public class ProvinceController {
    @Autowired
    ProvinceRepository provinceRepository ;
    @Autowired
    ProvinceService provinceService ;
    @RequestMapping(value="/provinces",method = RequestMethod.GET)
    @ResponseBody
    public List<TProvince> getProvinces(){
        return provinceRepository.findAll() ;
    }

    @RequestMapping(value="/province/{id}",method = RequestMethod.GET)
    @ResponseBody
    public TProvince getProvince(@PathVariable(value = "id") String id){
        return provinceRepository.findOne(Long.parseLong(id));
    }
}
