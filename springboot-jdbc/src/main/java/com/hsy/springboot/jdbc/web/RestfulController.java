package com.hsy.springboot.jdbc.web;

import com.hsy.springboot.demo.springboot.jdbc.bean.entity.TProvince;
import com.hsy.springboot.demo.springboot.jdbc.service.ITProvinceService;
import com.hsy.springboot.demo.springboot.jdbc.service.ITUserInfoService;
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
    ITProvinceService provinceService ;
    @Autowired
    ITUserInfoService userInfoService ;

    @RequestMapping(value = "/provinceList",method = RequestMethod.GET)
    @ResponseBody
    public List<TProvince> provinceList(){
        return provinceService.listTProvince() ;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public TProvince province(@PathVariable String id) {
        return provinceService.getById(id);
    }
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    @ResponseBody
    public boolean reigster(@RequestParam(value = "username") String username,
                            @RequestParam(value = "password") String password,
                            @RequestParam(value = "tel",required = false) String tel
                            ){
        int count = userInfoService.saveUserInfo(username,password) ;
        if(count>0){
            return true ;
        }else{
            return false ;
        }
    }
}
