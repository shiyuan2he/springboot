package com.springboot.config;

import com.springboot.service.beanway.impl.BeanWayServiceImpl;
import com.springboot.service.beanway.impl.JSR250WayServiceImpl;
import com.springboot.service.conditional.IListService;
import com.springboot.service.conditional.impl.LinuxIListServiceImpl;
import com.springboot.service.conditional.impl.WindowIListServiceImpl;
import org.springframework.context.annotation.*;

/**
 * Created by heshiyuan on 2017/4/5.
 */
//@Configuration
//@ComponentScan("com.springboot")
//@EnableAspectJAutoProxy
//@SpringBootAnnotation("com.springboot")
public class ConfigProperties {

    /*@Bean(initMethod = "init",destroyMethod = "destory")
    public BeanWayServiceImpl beanWayService(){
        return new BeanWayServiceImpl() ;
    }
    @Bean
    public JSR250WayServiceImpl jsr250WayService(){
        return new JSR250WayServiceImpl();
    }*/

    /**
     * @description <p>符合window系统就实例化WindowListServiceImpl类</p>
     * @return
     */
    /*@Bean
    @Conditional(WindowConditiaon.class)
    public IListService getWindowListService(){
        return new WindowIListServiceImpl() ;
    }*/
    /**
     * @description <p>符合linux系统就实例化LinuxListServiceImpl类</p>
     * @return
     */
   /* @Bean
    @Conditional(LinuxCondition.class)
    public IListService getLinuxListService(){
        return new LinuxIListServiceImpl() ;
    }*/
}
