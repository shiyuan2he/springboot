package com.hsy.springboot.cache.web;

import com.hsy.springboot.cache.dao.CacheDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/concurrentMapCache/cache")
public class RestfulController {

    @Autowired private CacheDao cacheDao ;
    /**
     * 查询方法
     */
    @GetMapping
    public String getDataWithCache() {
        Long startTime = System.currentTimeMillis();
        long timestamp = this.cacheDao.getDataWithCache() ;
        Long endTime = System.currentTimeMillis();
        System.out.println("耗时: " + (endTime - startTime));
        return timestamp+"";
    }

    /**
     * 保存方法
     */
    @PostMapping
    public void save() {
        this.cacheDao.save();
    }

    /**
     * 删除方法
     */
    @DeleteMapping
    public void delete() {
        this.cacheDao.delete();
    }
}
