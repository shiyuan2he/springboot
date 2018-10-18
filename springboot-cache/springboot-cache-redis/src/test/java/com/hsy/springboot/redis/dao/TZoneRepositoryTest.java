package com.hsy.springboot.redis.dao;

import com.hsy.springboot.redis.SpringBootRedisCacheApplication;
import com.hsy.springboot.redis.model.TZone;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRedisCacheApplication.class)
public class TZoneRepositoryTest {
    @Autowired
    private TZoneRepository tZoneRepository;
    @Before
    public void before() {
        tZoneRepository.save(new TZone(1000001,"AAA", 1000035l));
    }

    @Test
    public void test() throws Exception {
        TZone u1 = tZoneRepository.findByCode(1000001);
        System.out.println("第一次查询：" + u1.getSortId());

        TZone u2 = tZoneRepository.findByCode(1000001);
        System.out.println("第二次查询：" + u2.getSortId());

        u1.setSortId(20);
        tZoneRepository.save(u1);
        TZone u3 = tZoneRepository.findByCode(1000001);
        System.out.println("第三次查询：" + u3.getSortId());
        tZoneRepository.delete(u3);
    }

}
