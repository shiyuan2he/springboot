package com.hsy.springboot.jdbc.web;
import com.hsy.java.bean.dto.ResponseBodyBean;
import com.hsy.java.bean.po.TExerciseZone;
import com.hsy.java.bean.web.BaseController;
import com.hsy.java.util.json.JsonToBeanUtil;
import com.hsy.springboot.rpc.api.service.ITExerciseZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
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

    @RequestMapping(value = "/v1/reg",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseBodyBean<Boolean> reg(@RequestParam(value = "code") Integer code, @RequestParam String name,
                                      @RequestParam Long parentId, @RequestParam(required = false) Integer sortId, String remark){
        return success(exerciseZoneService.createTExerciseZone(code, name, parentId, sortId, remark));
    }

    @RequestMapping(value = "/v1/reg/batch",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseBodyBean<Boolean> batchReg(@RequestParam String json){

        JsonToBeanUtil.responseJsonToBeanEnhance(json, TExerciseZone.class) ;
        return null;
    }
    @RequestMapping(value = "/v1/delete/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseBodyBean<Boolean> delete(@PathVariable Long id){
        return success(exerciseZoneService.deleteTExerciseZone(id)) ;
    }

    @RequestMapping(value = "/v1/delete/batch",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseBodyBean<Boolean> batchDelete(List<Long> ids){
        return success(exerciseZoneService.batchDeleteTExerciseZone(ids));
    }

    @RequestMapping(value = "/v1/update/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseBodyBean<Boolean> update(TExerciseZone exerciseZone){
        return success(exerciseZoneService.updateTExerciseZone(exerciseZone));
    }

    @RequestMapping(value = "/v1/update/batch",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseBodyBean<Boolean> batchUpdate(List<TExerciseZone> list){
        return success(exerciseZoneService.batchUpdateTEerciseZone(list));
    }

    @RequestMapping(value = "/v1/zone/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseBodyBean<TExerciseZone> getZone(@PathVariable Long id){
        return success(exerciseZoneService.getOne(id)) ;
    }

    @RequestMapping(value = {"/v1/zones","/v1/zones/{offset}/{limit}"})
    public ResponseBodyBean<List<TExerciseZone>> getZones(@PathVariable Integer offset,@PathVariable Integer limit){
        return success(exerciseZoneService.getList(offset,limit));
    }
}
