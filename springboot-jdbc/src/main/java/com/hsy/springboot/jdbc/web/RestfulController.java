package com.hsy.springboot.jdbc.web;
import com.hsy.java.bean.dto.ResponseBodyBean;
import com.hsy.java.bean.po.TExerciseZone;
import com.hsy.java.bean.web.BaseController;
import com.hsy.java.util.json.JsonToBeanUtil;
import com.hsy.springboot.rpc.api.service.ITExerciseZoneService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author heshiyuan
 * @description <p>
        Api：修饰整个类，描述Controller的作用
        ApiOperation：描述一个类的一个方法，或者说一个接口
        ApiParam：单个参数描述
        ApiModel：用对象来接收参数
        ApiProperty：用对象接收参数时，描述对象的一个字段
        ApiResponse：HTTP响应其中1个描述
        ApiResponses：HTTP响应整体描述
        ApiIgnore：使用该注解忽略这个API
        ApiError ：发生错误返回的信息
        ApiParamImplicitL：一个请求参数
        ApiParamsImplicit 多个请求参数
 * </p>
 * @date 24/10/2017 7:50 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Api(value = "省市区接口服务",description = "省市区crud操作")
@RestController
@RequestMapping("/api/rest")
public class RestfulController extends BaseController{

    @Autowired private ITExerciseZoneService exerciseZoneService ;

    @ApiOperation(value = "用户注册接口",tags = "对外提供用户注册接口")
    @PostMapping(value = "/v1/reg",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseBodyBean<Boolean> reg(@RequestParam(value = "code") Integer code, @RequestParam String name,
                                      @RequestParam Long parentId, @RequestParam(required = false) Integer sortId, String remark){
        return success(exerciseZoneService.createTExerciseZone(code, name, parentId, sortId, remark));
    }
    @ApiOperation(value = "批量注册",tags = "对外提供批量注册接口")
    @PostMapping(value = "/v1/reg/batch",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseBodyBean<Boolean> batchReg(@RequestParam String json){

        JsonToBeanUtil.responseJsonToBeanEnhance(json, TExerciseZone.class) ;
        return null;
    }
    @ApiOperation(value = "指定id删除书籍",tags = "对外提供根据id单个删除书籍")
    //paramType 说明在路径当中
    @ApiImplicitParam(name = "id",value = "book主键ID",required = true,dataType = "Long",paramType = "path")
    @DeleteMapping(value = "/v1/delete/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseBodyBean<Boolean> delete(@PathVariable Long id){
        return success(exerciseZoneService.deleteTExerciseZone(id)) ;
    }

    @ApiOperation(value = "批量删除",tags = "批量删除服务")
    @ApiImplicitParam(name = "ids",value = "主键IDlist集合",required = true,dataType = "List<Long>",example = "{1,2,3,4}")
    @DeleteMapping(value = "/v1/delete/batch",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseBodyBean<Boolean> batchDelete(List<Long> ids){
        return success(exerciseZoneService.batchDeleteTExerciseZone(ids));
    }

    @ApiOperation(value = "指定id更新书籍",tags = "对外提供根据id单个更新书籍")
    //paramType 说明在路径当中
    @ApiImplicitParam(name = "id",value = "book主键ID",required = true,dataType = "Long",paramType = "path")
    @PutMapping(value = "/v1/update/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseBodyBean<Boolean> update(TExerciseZone exerciseZone){
        return success(exerciseZoneService.updateTExerciseZone(exerciseZone));
    }

    @ApiOperation(value = "批量更新",tags = "批量更新服务")
    @ApiImplicitParam(name = "list",value = "实体TExerciseZone list集合",required = true,dataType = "List<TExerciseZone>")
    @PutMapping(value = "/v1/update/batch",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseBodyBean<Boolean> batchUpdate(List<TExerciseZone> list){
        return success(exerciseZoneService.batchUpdateTEerciseZone(list));
    }

    @ApiOperation(value = "单个查询",tags = "查询单个书籍")
    @ApiImplicitParam(name = "id",value = "book主键ID",required = true,dataType = "Long",paramType = "path")
    @GetMapping(value = "/v1/zone/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseBodyBean<TExerciseZone> getZone(@PathVariable Long id){
        return success(exerciseZoneService.getOne(id)) ;
    }
    @ApiOperation(value = "批量查询",tags = "批量查询服务")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "offset",value = "从第几个开始查询",dataType = "Integer"),
        @ApiImplicitParam(name = "limit",value = "每页显示几个",dataType = "Integer")
    })
    @GetMapping(value = {"/v1/zones","/v1/zones/{offset}/{limit}"})
    public ResponseBodyBean<List<TExerciseZone>> getZones(@PathVariable(required = false) Integer offset,@PathVariable(required = false) Integer limit){
        return success(exerciseZoneService.getList(offset,limit));
    }
}
