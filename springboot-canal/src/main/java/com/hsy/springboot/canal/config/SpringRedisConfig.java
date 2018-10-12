package com.hsy.springboot.canal.config;
import com.askingdata.y.cache.redis.spring.object.impl.*;
import com.askingdata.y.cache.redis.spring.string.impl.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path base-service/com.hsy.base.service.redis.config
 * @date 2017/12/26 14:51
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@SuppressWarnings("Duplicates")
@Configuration
@ConditionalOnMissingClass
@Slf4j
public class SpringRedisConfig {
    @Autowired private RedisConfig redisConfig;
    @Autowired private RedisPoolConfig redisPoolConfig;
    /**
     * 配置RedisTemplate
     * 设置添加序列化器
     * key 使用string序列化器
     * value 使用Json序列化器
     * 还有一种简答的设置方式，改变defaultSerializer对象的实现。
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(RedisTemplate.class)
    public RedisTemplate<String, Object> redisTemplate() {
        log.info("正在初始化redisTemplate");
        //StringRedisTemplate的构造方法中默认设置了stringSerializer
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        // 设置key的序列化方式
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);

        // 设置value的序列化方式
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        //set value serializer
        template.setDefaultSerializer(jackson2JsonRedisSerializer);

        template.setConnectionFactory(jedisConnectionFactory());
        template.afterPropertiesSet();
        return template;
    }
    @Bean(name = "stringRedisTemplate")
    @ConditionalOnMissingBean(StringRedisTemplate.class)
    public StringRedisTemplate stringRedisTemplate(){
        log.info("正在初始化stringRedisTemplate");
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(jedisConnectionFactory());
        stringRedisTemplate.afterPropertiesSet();
        return stringRedisTemplate;
    }

    /**
     * 连接redis的工厂类
     *
     * @return
     */
    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        //构造方法中注入RedisSentinelConfiguration对象
        JedisConnectionFactory factory = new JedisConnectionFactory(jedisPoolConfig());
        factory.setHostName(redisConfig.getHost());
        factory.setPort(redisConfig.getPort());
        factory.setTimeout(redisConfig.getTimeout());
        factory.setDatabase(redisConfig.getDatabase());
        factory.setPassword(redisConfig.getPassword());
        return factory;
    }
    private JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig() ;
        jedisPoolConfig.setMaxTotal(redisPoolConfig.getMaxTotal()); // 设置最大实例总数
        jedisPoolConfig.setMaxIdle(redisPoolConfig.getMaxIdle());  // 设置一个pool最多有多少个状态为idle（空闲）的实例
        jedisPoolConfig.setMinIdle(redisPoolConfig.getMinIdle());  // 设置一个pool最少有多少个状态为idle（空闲）的实例
        // 表示当borrow（引入）一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException
        jedisPoolConfig.setMaxWaitMillis(redisPoolConfig.getMaxWaitMillis());
        // 再borrow一个redis实例的时候，是否提前进行alidate操作；true：得到的jedis是可用的；
        jedisPoolConfig.setTestOnBorrow(redisPoolConfig.isTestOnBorrow());
        jedisPoolConfig.setTestOnReturn(redisPoolConfig.isTestOnReturn());// 再还给pool时，是否提前进行validate操作。
        jedisPoolConfig.setTestWhileIdle(redisPoolConfig.isTestWhileIdle());
        jedisPoolConfig.setMinEvictableIdleTimeMillis(redisPoolConfig.getMinEvictableIdleTimeMillis());
        jedisPoolConfig.setSoftMinEvictableIdleTimeMillis(redisPoolConfig.getSoftMinEvictableIdleTimeMillis());
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(redisPoolConfig.getTimeBetweenEvictionRunsMillis()) ;
        jedisPoolConfig.setNumTestsPerEvictionRun(redisPoolConfig.getNumTestsPerEvictionRun());
        return jedisPoolConfig ;
    }
    // ============//
    @Bean
    public StringValueOperationsBase stringValueOperationsBase(){
        log.info("正在初始化stringValueOperationsBase。。。");
        return new StringValueOperationsBase() {
            @Override
            public StringRedisTemplate getStringRedisTemplate() {
                return stringRedisTemplate();
            }
        };
    }
    @Bean
    public StringHashOperationsBase stringHashOperationsBase(){
        log.info("正在初始化stringHashOperationsBase。。。");
        return new StringHashOperationsBase() {
            @Override
            public StringRedisTemplate getStringRedisTemplate() {
                return stringRedisTemplate();
            }
        };
    }
    @Bean
    public StringSetOperationsBase stringSetOperationsBase(){
        log.info("正在初始化stringSetOperationsBase。。。");
        return new StringSetOperationsBase() {
            @Override
            public StringRedisTemplate getStringRedisTemplate() {
                return stringRedisTemplate();
            }
        };
    }
    @Bean
    public StringZSetOperationsBase stringZSetOperationsBase(){
        log.info("正在初始化stringZSetOperationsBase。。。");
        return new StringZSetOperationsBase() {
            @Override
            public StringRedisTemplate getStringRedisTemplate() {
                return stringRedisTemplate();
            }
        };
    }
    @Bean
    public StringListOperationsBase stringListOperationsBase(){
        log.info("正在初始化stringListOperationsBase。。。");
        return new StringListOperationsBase() {
            @Override
            public StringRedisTemplate getStringRedisTemplate() {
                return stringRedisTemplate();
            }
        };
    }
    // ============//
    @Bean
    public ValueOperationsBase valueOperationsBase(){
        log.info("正在初始化valueOperationsBase。。。");
        return new ValueOperationsBase() {
            @Override
            public RedisTemplate getRedisTemplate() {
                return redisTemplate();
            }
        };
    }
    @Bean
    public HashOperationsBase hashOperationsBase(){
        log.info("正在初始化hashOperationsBase。。。");
        return new HashOperationsBase() {
            @Override
            public RedisTemplate getRedisTemplate() {
                return redisTemplate();
            }
        };
    }
    @Bean
    public SetOperationsBase setOperationsBase(){
        log.info("正在初始化setOperationsBase。。。");
        return new SetOperationsBase() {
            @Override
            public RedisTemplate getRedisTemplate() {
                return redisTemplate();
            }
        };
    }
    @Bean
    public ZSetOperationsBase zSetOperationsBase(){
        log.info("正在初始化zSetOperationsBase。。。");
        return new ZSetOperationsBase() {
            @Override
            public RedisTemplate getRedisTemplate() {
                return redisTemplate();
            }
        };
    }
    @Bean
    public ListOperationsBase listOperationsBase(){
        log.info("正在初始化listOperationsBase。。。");
        return new ListOperationsBase() {
            @Override
            public RedisTemplate getRedisTemplate() {
                return redisTemplate();
            }
        };
    }
}
