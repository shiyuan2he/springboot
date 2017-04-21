package com.springboot.annotation;

import com.springboot.service.beanway.impl.BeanWayServiceImpl;
import com.springboot.service.beanway.impl.JSR250WayServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import sun.misc.Contended;

/**
 * Created by heshiyuan on 2017/4/5.
 */
@Configuration
@ComponentScan("com.springboot")
@EnableAspectJAutoProxy
public class ConfigProperties {

    @Bean(initMethod = "init",destroyMethod = "destory")
    BeanWayServiceImpl beanWayService(){
        return new BeanWayServiceImpl() ;
    }
    @Bean
    JSR250WayServiceImpl jsr250WayService(){
        return new JSR250WayServiceImpl();
    }
}
