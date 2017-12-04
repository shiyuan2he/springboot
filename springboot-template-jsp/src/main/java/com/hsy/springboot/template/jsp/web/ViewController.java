package com.hsy.springboot.template.jsp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot/com.hsy.springboot.template.jsp.web
 * @date 2017/12/2 20:54
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Controller
public class ViewController {

    /**
     * @description <p></p>
     * @return
     * @author heshiyuan
     * @date 2017/12/2 20:56
     */
    @RequestMapping(value = {"/","/index"})
    public String index(HttpServletRequest request){
        request.setAttribute("content","this is index");
        request.setAttribute("time", Calendar.getInstance().getTime());
        // 自动映射到"/WEB-INF/jsp/"下
        return "index" ;
    }

    @RequestMapping("/toPage1View")
    public String page1(Model model){
        model.addAttribute("time",Calendar.getInstance().getTime()) ;
        model.addAttribute("content","this is page1");
        return "page/page1" ;
    }

    @RequestMapping("/toPage2View")
    public ModelAndView page1(ModelAndView modelAndView){
        modelAndView.setViewName("page/page2");
        modelAndView.addObject("time",Calendar.getInstance().getTime()) ;
        modelAndView.addObject("content","this is page1") ;
        return modelAndView;
    }
}
