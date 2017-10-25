package com.hsy.springboot.demo.springboot.mybatis.web;

import com.hsy.springboot.demo.springboot.mybatis.bean.entity.TProvince;
import com.hsy.springboot.demo.springboot.mybatis.service.IProvinceService;
import com.hsy.springboot.demo.springboot.mybatis.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot.demo/com.hsy.springboot.demo.springboot.jdbc.web
 * @date 24/10/2017 7:50 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@RestController
@RequestMapping("/rest")
public class RestfulController {
    @Autowired
    IProvinceService provinceService ;
    @Autowired
    IUserInfoService userInfoService ;

    @RequestMapping(value = "/provinceList",method = RequestMethod.GET)
    @ResponseBody
    public List<TProvince> provinceList(){
        return provinceService.getProvinceList() ;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public TProvince province(@PathVariable String id) {
        return provinceService.getProvinceById(id) ;
    }
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    @ResponseBody
    public boolean reigster(@RequestParam(value = "username") String username,
                            @RequestParam(value = "password") String password,
                            @RequestParam(value = "tel",required = false) String tel
                            ){
        if(userInfoService.save(username,password)){
            return true ;
        }else{
            return false ;
        }
    }
}
