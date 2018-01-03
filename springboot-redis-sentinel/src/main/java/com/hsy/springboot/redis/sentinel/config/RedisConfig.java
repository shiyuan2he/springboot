package com.hsy.springboot.redis.sentinel.config;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.lang.reflect.Method;

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
@Configuration
@EnableAutoConfiguration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.database}")
    private int database;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.sentinel.nodes}")
    private String redisNodes;

    @Value("${spring.redis.sentinel.master}")
    private String master;

    /**
     * 配置RedisTemplate
     * 设置添加序列化器
     * key 使用string序列化器
     * value 使用Json序列化器
     * 还有一种简答的设置方式，改变defaultSerializer对象的实现。
     *
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        //StringRedisTemplate的构造方法中默认设置了stringSerializer
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        //set key serializer
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);

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

    /**
     * redis哨兵配置
     *
     * @return
     */
    @Bean
    public RedisSentinelConfiguration redisSentinelConfiguration() {
        RedisSentinelConfiguration configuration = new RedisSentinelConfiguration();
        String[] host = redisNodes.split(",");
        for (String redisHost : host) {
            String[] item = redisHost.split(":");
            String ip = item[0];
            String port = item[1];
            configuration.addSentinel(new RedisNode(ip, Integer.parseInt(port)));
        }
        configuration.setMaster(master);
        return configuration;
    }

    /**
     * 连接redis的工厂类
     *
     * @return
     */
    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        //构造方法中注入RedisSentinelConfiguration对象
        JedisConnectionFactory factory = new JedisConnectionFactory(redisSentinelConfiguration());
        factory.setHostName(host);
        factory.setPort(port);
        factory.setTimeout(timeout);
        factory.setPassword(password);
        factory.setDatabase(database);
        factory.setPoolConfig(jedisPoolConfig());
        return factory;
    }

    /**
     * 设置RedisCacheManager
     * 使用cache注解管理redis缓存
     *
     * @return
     */
    @Bean
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate());
        return redisCacheManager;
    }

    /**
     * 自定义生成redis-key
     *
     * @return
     */
    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                sb.append(o.getClass().getName()).append(".");
                sb.append(method.getName()).append(".");
                for (Object obj : objects) {
                    sb.append(obj.toString());
                }
                System.out.println("keyGenerator=" + sb.toString());
                return sb.toString();
            }
        };
    }

    private JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(500); // 设置最大实例总数
        jedisPoolConfig.setMaxIdle(100);  // 设置一个pool最多有多少个状态为idle（空闲）的实例
        jedisPoolConfig.setMinIdle(100);  // 设置一个pool最少有多少个状态为idle（空闲）的实例
        // 表示当borrow（引入）一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException
        jedisPoolConfig.setMaxWaitMillis(3 * 1000);
        // 再borrow一个redis实例的时候，是否提前进行alidate操作；true：得到的jedis实力均是可用的；
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPoolConfig.setTestOnReturn(true);// 再还给pool时，是否提前进行validate操作。
        jedisPoolConfig.setTestWhileIdle(true);
        jedisPoolConfig.setMinEvictableIdleTimeMillis(500);
        jedisPoolConfig.setSoftMinEvictableIdleTimeMillis(1000);
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(1000);
        jedisPoolConfig.setNumTestsPerEvictionRun(100);
        return jedisPoolConfig;
    }
}