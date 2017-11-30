package com.hsy.springboot.rabbitmq.producer;
import com.hsy.springboot.rabbitmq.utils.MQConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Producer {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessageRabbitmq(final String message) {
        logger.info("生产者正在生产消息：{}",message);
        this.rabbitTemplate.convertAndSend(MQConstant.EXCHANGE_NAME,MQConstant.QUEUE_NAME,message);
    }

}
