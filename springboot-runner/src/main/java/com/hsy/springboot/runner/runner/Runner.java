package com.hsy.springboot.runner.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner{
    private final Logger _logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void run(String... strings) throws Exception {
        _logger.info("服务启动时执行此方法");
    }
}
