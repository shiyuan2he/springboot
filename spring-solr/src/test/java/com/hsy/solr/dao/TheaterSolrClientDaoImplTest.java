package com.hsy.solr.dao;
import com.hsy.solr.bean.TheaterSolrBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext*.xml")
public class TheaterSolrClientDaoImplTest {
    @Autowired
    TheaterSolrDao theaterSolrDao ;
    @Test
    public void testSelect() {
        TheaterSolrBean theaterSolrBean = new TheaterSolrBean() ;
        //theaterSolrBean.setKeyWords("戏剧");
        //theaterSolrBean.setId(10004l);
        try {
            theaterSolrDao.selectBeanList(theaterSolrBean,1,5) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
