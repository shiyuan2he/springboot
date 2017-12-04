package com.hsy.springboot.filter.listener.config;

import com.hsy.springboot.filter.listener.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
   /* @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        return new FilterRegistrationBean(new MyFilter()) ;
    }*/

}
