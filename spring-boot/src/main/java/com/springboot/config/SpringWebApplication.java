package com.springboot.config;

import com.springboot.annotation.SpringBootAnnotation;
import com.springboot.core.TimeInterceptor;
import com.springboot.service.conditional.IListService;
import com.springboot.service.conditional.impl.LinuxIListServiceImpl;
import com.springboot.service.conditional.impl.WindowIListServiceImpl;
import com.springboot.service.taskexecutor.impl.TaskExecutorServiceImpl;
import com.springboot.service.webinit.impl.WebInitializerServiceImpl;
import com.springboot.util.LinuxCondition;
import com.springboot.util.WindowConditiaon;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.concurrent.Executor;

/**
 * @description <p>springweb 应用配置</p>
 * @path spring-boot/com.springboot.annotation
 * @author heshiyuan
 * @date 2017/4/26 下午3:00
 * @github http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@SpringBootAnnotation
public class SpringWebApplication extends WebMvcConfigurerAdapter implements AsyncConfigurer {

    /**
     * @description <p>springMVC视图前后缀匹配文件</p>
     * @param
     * @author heshiyuan
     * @date 2017/5/25 上午11:16
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    @SuppressWarnings("unused")
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver ;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/") ;
    }

    @Bean
    public WebInitializerServiceImpl beanInitService(){
        return new WebInitializerServiceImpl() ;
    }
    /**
     * @description <p>符合window系统就实例化WindowListServiceImpl类</p>
     * @return
     */
    @Bean
    @Conditional(WindowConditiaon.class)
    public IListService getWindowListService(){
        return new WindowIListServiceImpl() ;
    }
    /**
     * @description <p>符合linux系统就实例化LinuxListServiceImpl类</p>
     * @return
     */
    @Bean
    @Conditional(LinuxCondition.class)
    public IListService getLinuxListService(){
        return new LinuxIListServiceImpl() ;
    }
    /**
     * @description <p>注解实例化业务bean</p>
     * @author heshiyuan
     * @date 2017/5/25 下午4:58
     */
    @Bean
    public TaskExecutorServiceImpl getTaskExecutorService(){
        return new TaskExecutorServiceImpl() ;
    }

    @Bean
    public TimeInterceptor getTimeInterceptor(){
        return new TimeInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(getTimeInterceptor()) ;
    }
    /**
     * @description <p></p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 2017/5/25 下午2:32
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecuttor = new ThreadPoolTaskExecutor();
        taskExecuttor.setCorePoolSize(5);
        taskExecuttor.setMaxPoolSize(10);
        taskExecuttor.setQueueCapacity(25);
        taskExecuttor.initialize();
        return taskExecuttor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
