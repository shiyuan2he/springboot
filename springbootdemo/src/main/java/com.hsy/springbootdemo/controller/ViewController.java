package com.hsy.springbootdemo.controller;

import com.hsy.springbootdemo.javabean.modelbean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path spring/com.hsy.springbootdemo.controller
 * @date 2017/7/4 下午10:45
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Controller
@RequestMapping("/view")
public class ViewController {
    @RequestMapping("/index")
    public String index(Model model){
        Person person = new Person(26,"heshiyuan1") ;
        List<Person> list = new ArrayList<Person>() ;
        Person person1 = new Person(28,"heshiyuan2") ;
        Person person2= new Person(29,"heshiyuan3") ;
        Person person3 = new Person(30,"heshiyuan4") ;
        list.add(person1);
        list.add(person2);
        list.add(person3) ;
        model.addAttribute("person",person);
        model.addAttribute("list",list) ;
        return "index" ;
    }
    @RequestMapping("/websocket")
    public String websocket(Model model){
        return "websocket/websocket" ;
    }
}
