package com.hsy.springboot.redis.dao;
import com.hsy.springboot.redis.model.TZone;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author heshiyuan
 * @description <p></p>
 * @date 25/10/2017 4:02 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@CacheConfig(cacheNames = "tZone")
public interface TZoneRepository extends JpaRepository<TZone, Long> {

    @Cacheable(value = "tZone", key = "#code", condition = "#result != null")
    TZone findByCode(Integer code);

    @CachePut(value = "tZone", key = "#tZone.code")
    TZone save(TZone tExerciseZone);

}
