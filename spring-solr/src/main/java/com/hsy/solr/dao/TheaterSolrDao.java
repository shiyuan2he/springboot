package com.hsy.solr.dao;

import com.hsy.solr.bean.PageBean;
import com.hsy.solr.bean.TheaterSolrBean;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path java/com.java.dao.impl
 * @date 2017/7/1 11:35
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public interface TheaterSolrDao {

    PageBean selectBeanList(TheaterSolrBean theaterSolrBean, Integer newPage, Integer pageSize) throws Exception;
}
