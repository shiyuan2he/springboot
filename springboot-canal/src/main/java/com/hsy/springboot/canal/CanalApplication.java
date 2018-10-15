package com.hsy.springboot.canal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SuppressWarnings("Duplicates")
@SpringBootApplication
public class CanalApplication {

    public static void main(String[] args){
//        SpringApplication.run(CanalApplication.class,args) ;
        // 启动Spring的应用上下文
        SpringApplication app = new SpringApplication(CanalApplication.class);

        // app.setWebEnvironment(true);

        // Set<Object> set = new HashSet<Object>();
        // set.add("classpath:applicationContext.xml");

        // app.setSources(set);
        app.run(args);
    }
}
