package com.hsy.springboot.redis;

import com.hsy.springboot.redis.dao.RedisRepository;
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
    @Autowired private RedisRepository redisRepository ;
    @Test
    public void putCache() {
        try{
            redisRepository.putCache("test:redis","sfasdfasdfsdf") ;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void putCacheWithExpireTime() throws Exception {
        redisRepository.putCacheWithExpireTime("test:redis2","sfasdfasdfsdf",5) ;
    }

    @Test
    public void delete() throws Exception {
        redisRepository.deleteCacheByKey("test:redis");
    }
}
