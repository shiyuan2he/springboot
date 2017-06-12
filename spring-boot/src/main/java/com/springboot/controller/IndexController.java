package com.springboot.controller;

import com.springboot.annotation.Action;
import com.springboot.javabean.User;
import oracle.jvm.hotspot.jfr.Producer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path spring-boot/com.springboot.controller
 * @date 2017/4/26 下午10:40
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Controller   //申明在类上，表明这个类是springMVC里的Controller，将其申明为一个bean，Dispatcher会自动扫描注解了此类注解的类
//用来映射web 请求，处理类和方法的，可以注解在类上，也可以注解在方法上，支持Servlet的response和reqeust作为参数
//也支持reqeust，response的媒体类型进行配置
@RequestMapping("/index")
public class IndexController {
    /**
     * @description <p>跳转到欢迎页</p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 2017/5/19 下午9:33 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    @Action(name="进入首页")
    @RequestMapping("/hello")
    public String hello(){
        return "hello" ;
    }

    /**
     * @description <p>将返回字符串封装在response中</p>
     * @param request
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 2017/6/11 上午10:45
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    // ResponseBody支持将返回值放到response体内，而不是返回一个页面，在很多基于ajax的程序的时候，可以使用此注解
    // produces可以定制返回的response的媒体类型和字符集
    @RequestMapping(produces="text/plain;charset=UTF-8")
    public @ResponseBody String getAddress(HttpServletRequest request){
        return "www.baidu.com" ;
    }

    // @PathVariable用来接受路径参数
    @RequestMapping(value="/pathvar/{str}",produces="text/plain;charset=UTF-8")
    public @ResponseBody String getAddressByVar(@PathVariable String str, HttpServletRequest request){
        return str ;
    }

    // @PathVariable用来接受路径参数
    @RequestMapping(value="/getUserInfo",produces="application/json;charset=UTF-8")
    @ResponseBody
    public String getUserInfo(User user, HttpServletRequest request){
        return user.getId()+user.getName()+user.getCardNo() ;
    }

    // 获取 /index/getId?id=100001 中ID的值
    @RequestMapping(value="/getId",produces="application/json;charset=UTF-8")
    @ResponseBody
    public String getUrlParam(Long id, HttpServletRequest request){
        return id.toString() ;
    }

    // 不同的路径也能调用相同的方法
    @RequestMapping(value={"/getId1","getId2"},produces="application/json;charset=UTF-8")
    @ResponseBody
    public String getUrlParamByTwo(Long id, HttpServletRequest request){
        return id.toString() ;
    }
}
