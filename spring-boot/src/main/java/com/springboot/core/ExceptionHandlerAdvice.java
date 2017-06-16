package com.springboot.core;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author heshiyuan
 * @description <p>controller层全局日志</p>
 * @path spring-boot/com.springboot.core
 * @date 2017/6/11 下午2:24
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception exception , WebRequest request){
        ModelAndView modelAndView = new ModelAndView("exception") ;
        modelAndView.addObject("errorMsg",exception.getMessage()) ;
        return modelAndView ;
    }

    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("msg","额外信息") ;
    }
}
