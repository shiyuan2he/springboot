package com.hsy.springboot.template.freemarker.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

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
        //request.setAttribute("time", Calendar.getInstance().getTime());
        // 自动映射到"/WEB-INF/jsp/"下
        return "index" ;
    }
}
