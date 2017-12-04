package com.hsy.springboot.servlet.config;

import com.hsy.springboot.servlet.servlet.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class ServertConfig {
    /**
     * 方法一：通过ServletRegistrationBean注册
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new MyServlet(),"/myServlet/*") ;
    }

    /*@Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
        registration.getUrlMappings().clear();
        registration.addUrlMappings("*.do");
        registration.addUrlMappings("*.view");
        registration.addUrlMappings("*.json");
        return registration;
    }*/
}
