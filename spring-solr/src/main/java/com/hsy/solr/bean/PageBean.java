package com.hsy.solr.bean;

import java.util.List;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path java/com.java.bean
 * @date 2017/7/1 13:11
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class PageBean {
    List<TheaterSolrBean> theaterSolrBeanList ;
    Integer nowPage ;
    Integer pageSize ;
    Long totalCount ;

    public List<TheaterSolrBean> getTheaterSolrBeanList() {
        return theaterSolrBeanList;
    }

    public void setTheaterSolrBeanList(List<TheaterSolrBean> theaterSolrBeanList) {
        this.theaterSolrBeanList = theaterSolrBeanList;
    }

    public Integer getNowPage() {
        return nowPage;
    }

    public void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
