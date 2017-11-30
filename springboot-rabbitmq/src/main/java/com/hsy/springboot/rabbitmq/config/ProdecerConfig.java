package com.hsy.springboot.rabbitmq.config;
import com.hsy.springboot.rabbitmq.utils.MQConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ProdecerConfig {
    //信道配置
    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(MQConstant.EXCHANGE_NAME, true, false);
    }
    @Bean
    public Queue queue() {
        Queue queue = new Queue(MQConstant.QUEUE_NAME,true);
        return queue;
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(defaultExchange()).with(MQConstant.QUEUE_NAME);
    }

}
