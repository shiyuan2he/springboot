package com.hsy.solr.util;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.java.util
 * @date 2017/7/1 11:00
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class SolrUtil {
    private static SolrUtil solrUtil = new SolrUtil() ;
    private static SolrClient client=null;

    static{
        //1.创建链接
        client = new HttpSolrClient("http://192.168.216.129:8080/solr");
    }

    private SolrUtil(){}

    public synchronized static SolrUtil getInstance(){
        return solrUtil;
    }

    public static SolrClient getClient(){
        if(null!=client){
            return client ;
        }else{
            System.out.println("初始化HttpSolrClient没有成功！没有连接上http://118.178.188.21:81/solr/poly....") ;
        }
        return null ;
    }
}
