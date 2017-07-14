package com.hsy.springbootdemo;

import com.hsy.springbootdemo.javabean.protocolbean.Author;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path spring/PACKAGE_NAME
 * @date 2017/6/27 15:22
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Controller
@SpringBootApplication
@MapperScan(basePackages = "com.hsy.springbootdemo.mapper")
public class SpringBootDemoApplication {
    @Autowired
    Author author ;
    @RequestMapping("/")
    String home() {
        return "redirect:countries";
    }
    public static void main(String[] args){
        SpringApplication.run(SpringBootDemoApplication.class,args);
    }

    /*@Bean
    public EmbeddedServletContainerFactory servletContainer(){
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory(){
            protected void postProcessContext(Context context){
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection securityCollection = new SecurityCollection();
                securityCollection.addPattern("*//*");
                securityConstraint.addCollection(securityCollection);
                context.addConstraint(securityConstraint);
            }
        } ;
        tomcat.addAdditionalTomcatConnectors(httpConnector());
        return tomcat ;
    }
    @Bean
    public Connector httpConnector(){
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol") ;
        connector.setScheme("http") ;
        connector.setPort(10000) ;
        connector.setSecure(false);
        connector.setRedirectPort(8443);
        return connector ;
    }*/
}
