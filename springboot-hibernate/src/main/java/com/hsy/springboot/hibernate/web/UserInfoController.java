package com.hsy.springboot.hibernate.web;

import com.hsy.springboot.demo.jpa.entity.TUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot.demo/com.hsy.springboot.demo.jpa.web
 * @date 25/10/2017 4:40 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@RestController
public class UserInfoController {
    private Logger _logger = LoggerFactory.getLogger(this.getClass()) ;
    @RequestMapping(value="/reg",method = RequestMethod.GET)
    public String reg(@Valid TUserInfo userInfo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            _logger.info(bindingResult.getFieldError().getDefaultMessage());
            return bindingResult.getFieldError().getDefaultMessage() ;
        }
        return "success";
    }
}
