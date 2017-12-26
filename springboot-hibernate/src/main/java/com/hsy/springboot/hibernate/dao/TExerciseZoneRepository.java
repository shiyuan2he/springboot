package com.hsy.springboot.hibernate.dao;

import com.hsy.springboot.hibernate.entity.TExerciseZone;
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
@Repository(value = "exerciseZoneRepository")
public interface TExerciseZoneRepository extends JpaRepository<TExerciseZone,Long> {
}
