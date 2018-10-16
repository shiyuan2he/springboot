package com.hsy.springboot.redis.dao;
import com.hsy.springboot.redis.model.TZone;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heshiyuan
 * @description <p></p>
 * @date 25/10/2017 4:02 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@CacheConfig(cacheNames = "tExerciseZone")
@Repository(value = "exerciseZoneRepository")
public interface TExerciseZoneRepository extends JpaRepository<TZone, Long> {

    @Cacheable(key = "#p0")
    TZone findByCode(Integer code);

    @CachePut(key = "#p0.code")
    TZone save(TZone tExerciseZone);

}
