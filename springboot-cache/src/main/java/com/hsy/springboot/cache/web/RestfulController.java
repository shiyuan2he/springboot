package com.hsy.springboot.cache.web;

import com.hsy.springboot.cache.dao.CacheDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@Api(value = "缓存测试接口",description = "测试缓存增删改查")
@RestController
@RequestMapping(value = "/api/concurrenmapcache/cache")
public class RestfulController {

    @Autowired private CacheDao cacheDao ;
    /**
     * 查询方法
     */
    @ApiOperation(value = "查询缓存",notes = "第一次查询慢，后面会比较快")
    @RequestMapping(value = "", method = RequestMethod.GET)
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
    @ApiOperation(value = "保存进缓存",notes = "将数据缓存起来")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void save() {
        this.cacheDao.save();
    }

    /**
     * 删除方法
     */
    @ApiOperation(value = "删除缓存",notes = "将数据从缓存中删除")
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public void delete() {
        this.cacheDao.delete();
    }
}
