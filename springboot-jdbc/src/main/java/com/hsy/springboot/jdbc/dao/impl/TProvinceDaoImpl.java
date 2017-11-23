package com.hsy.springboot.jdbc.dao.impl;

import org.springframework.stereotype.Repository;
/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot.demo/com.hsy.springboot.demo.springboot.jdbc.dao.impl
 * @date 24/10/2017 7:46 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price &yen;5    &#x5fae;&#x4fe1;&#xff1a;hewei1109
 */
@Repository("provinceDao")
public class TProvinceDaoImpl{
    /*@Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<TProvince> getTProvinceList() {
        List<TProvince> list = jdbcTemplate.query("select * from t_province", new Object[]{}, new BeanPropertyRowMapper(TProvince.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    @Override
    public TProvince getTProvinceById(String id) {
        TProvince province = jdbcTemplate.queryForObject("select * from t_province where id = ?", new Object[]{id}, TProvince.class) ;
        *//*List<TProvince> list = jdbcTemplate.query("select * from t_province where id = ?", new Object[]{id}, new BeanPropertyRowMapper(TProvince.class));
        if(null!=list&&list.size()>0){
            return list.get(0);
        }*//*
        return province;
    */
}
