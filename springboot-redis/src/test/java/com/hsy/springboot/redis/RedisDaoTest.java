package com.hsy.springboot.redis;

import com.hsy.springboot.redis.dao.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRedisApplication.class)
public class RedisDaoTest {
    private final Logger _logger = LoggerFactory.getLogger(this.getClass()) ;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired private RedisDao redisDao ;
    @Test
    public void setKey() throws Exception {
        redisDao.setKey("name","hsy");
        redisDao.setKey("age","18");
    }

    @Test
    public void getValue() throws Exception {
        _logger.info(redisDao.getValue("name"));
        _logger.info(redisDao.getValue("age"));
    }

}
