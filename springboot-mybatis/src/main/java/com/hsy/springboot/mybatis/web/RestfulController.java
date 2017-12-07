package com.hsy.springboot.mybatis.web;

import com.hsy.java.bean.dto.ResponseBodyBean;
import com.hsy.java.bean.po.TExerciseZone;
import com.hsy.java.bean.web.BaseController;
import com.hsy.springboot.mybatis.service.ITExerciseZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot.demo/com.hsy.springboot.demo.springboot.jdbc.web
 * @date 24/10/2017 7:50 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@RestController
@RequestMapping("/api/rest")
public class RestfulController extends BaseController{

    @Autowired private ITExerciseZoneService exerciseZoneService ;

    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseBodyBean<Boolean> update(@PathVariable Long id,@RequestParam Integer parentId){
        return success(exerciseZoneService.update(parentId,id)) ;
    }

    @GetMapping(value = {"/v1/zones/{offset}/{limit}"})
    public ResponseBodyBean<List<TExerciseZone>> zoneList(@PathVariable Integer offset, @PathVariable Integer limit){
        return success(exerciseZoneService.getAll(offset,limit)) ;
    }
}
