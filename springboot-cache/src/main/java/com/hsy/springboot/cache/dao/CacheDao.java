package com.hsy.springboot.cache.dao;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository(value = "cacheDao")
public class CacheDao {

    /**
     * 缓存key concurrenmapcache
     *
     * @return
     */
    @Cacheable(value = "concurrenmapcache")
    public long getDataWithCache() {
        try {
            // 阻塞三秒，模拟查询数据库耗时
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Timestamp(System.currentTimeMillis()).getTime();
    }

    /**
     * CachePut 与 Cacheable 类似，但是它无论什么情况，
     * 都会将方法的返回值放到缓存中, 主要用于数据新增和修改方法。
     * @return
     */
    @CachePut(value = "concurrenmapcache")
    public long save() {
        long timestamp = new Timestamp(System.currentTimeMillis()).getTime();
        System.out.println("进行缓存：" + timestamp);
        return timestamp;
    }

    /**
     * @CacheEvict 将一条或多条数据从缓存中删除, 主要用于删除方法，用来从缓存中移除相应数据。
     */
    @CacheEvict(value = "concurrenmapcache")
    public void delete() {
        System.out.println("删除缓存");
    }
}
