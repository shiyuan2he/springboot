package com.hsy.springboot.cache.web;

import com.hsy.springboot.cache.dao.CacheDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @DeleteMapping
    public void delete() {
        this.cacheDao.delete();
    }
    @GetMapping(value = "/user/{userId}")
    public Map<String, Object> getUserInfo(@PathVariable(value = "userId") String userId) {
        long startTime = System.currentTimeMillis();
        Map<String, Object> returnMap = this.cacheDao.getUserInfo(userId);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时: " + (endTime - startTime));
        return returnMap;
    }
    @PostMapping(value = "/user/{userId}")
    public void updateUserInfo(@PathVariable(value = "userId") String userId, String userName) {
        this.cacheDao.updateUserInfo(userId, userName);
    }
    @DeleteMapping(value = "/user/{userId}")
    public void deleteUserInfo(@PathVariable(value = "userId") String userId) {
        this.cacheDao.deleteUserInfo();
    }
}
