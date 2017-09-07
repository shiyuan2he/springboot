package com.hsy.solr.dao;

import com.hsy.solr.bean.PageBean;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author heshiyuan
 * @description <p>solr增删改查</p>
 * @path java/com.java.dao
 * @date 2017/7/1 11:05
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public interface SolrDao<O> {
    /**
     * @param objectMap
     * @return
     */
    Integer addByField(Map<String,Object> objectMap) ;

    /**
     * @param o 传入的solr实体bean
     * @return
     */
    Integer addByBean(O o) throws IOException, SolrServerException;
    /**
     * @param oList 传入的solr实体bean list集合
     * @return
     */
    Integer addByBeans(List<O> oList) throws IOException, SolrServerException;

    PageBean selectBeanList(O o, Integer newPage, Integer pageSize) ;

    /**
     * @param id    solr库索引id
     * @return
     */
    O getById(Long id) throws IOException, SolrServerException;
    /**
     * @param id    根据索引id删除
     * @return
     */
    Integer deleteById(Long id);
    /**
     * 删除所有数据
     * @return
     */
    Integer deleteAll() throws IOException, SolrServerException;
    /**
     * @param o    根据参数删除
     * @return
     */
    Integer deleteByParam(O o);

    Integer update(O o) ;
}
