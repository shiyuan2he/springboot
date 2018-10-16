package com.hsy.springboot.redis.dao;

import com.hsy.springboot.redis.SpringBootRedisCacheApplication;
import com.hsy.springboot.redis.model.TZone;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRedisCacheApplication.class)
public class UserRepositoryTest {
    @Autowired
    private TExerciseZoneRepository exerciseZoneRepository;

    @Autowired
    private CacheManager cacheManager;

    @Before
    public void before() {
        exerciseZoneRepository.save(new TZone(1000000,"AAA", 0l));
    }

    @Test
    public void test() throws Exception {
        TZone u1 = exerciseZoneRepository.findByCode(1000000);
        System.out.println("第一次查询：" + u1.getSortId());

        TZone u2 = exerciseZoneRepository.findByCode(1000000);
        System.out.println("第二次查询：" + u2.getSortId());

        u1.setSortId(20);
        exerciseZoneRepository.save(u1);
        TZone u3 = exerciseZoneRepository.findByCode(1000000);
        System.out.println("第三次查询：" + u3.getSortId());
    }

}
