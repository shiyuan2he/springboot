package com.hsy.springboot.rabbitmq.consumer;

import com.hsy.springboot.rabbitmq.config.ProdecerConfig;
import com.hsy.springboot.rabbitmq.utils.MQConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    private final Logger logger = LoggerFactory.getLogger(this.getClass()) ;

    @RabbitListener(queues = MQConstant.QUEUE_NAME)
    public void receive(String receiveName){
        logger.info("hello,this is receiver:{}",receiveName);
    }
}
