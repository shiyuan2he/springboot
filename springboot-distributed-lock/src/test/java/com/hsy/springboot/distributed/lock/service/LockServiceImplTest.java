package com.hsy.springboot.distributed.lock.service;
import com.hsy.java.base.utils.ConcurrentMock;
import com.hsy.springboot.distributed.lock.DistributedLockApplication;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot/com.hsy.springboot.distributed.lock.service
 * @date 2018/7/20 15:07
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@SpringBootTest(classes = DistributedLockApplication.class)
@RunWith(SpringRunner.class)
public class LockServiceImplTest extends ConcurrentMock {

    @Autowired private LockServiceImpl lockService;
    @org.junit.Test
    public void dbLock() {
        try {
            execute();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @org.junit.Test
    public void redisLock() {
        try {
            execute();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

        @Override
    public int getConcurrentNo() {
        return 100;
    }

    @Override
    public void doMethod() {
        lockService.redisLock();
    }

    @Override
    public int getSleepTime() {
        return 5 * 1000;
    }
}