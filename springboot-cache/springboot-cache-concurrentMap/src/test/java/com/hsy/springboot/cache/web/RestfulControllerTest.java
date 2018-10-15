package com.hsy.springboot.cache.web;
import com.hsy.springboot.cache.ConcurrentMapCacheApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ConcurrentMapCacheApplication.class)
@WebAppConfiguration
//@WebMvcTest
public class RestfulControllerTest {

    @Autowired private WebApplicationContext context ;

    private MockMvc mockMvc ;

    @Before
    public void before(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build() ;
    }
    @Test
    public void getDataWithCache() throws Exception {
        for (int i = 0; i < 10; i++) {
            mockMvc.perform(MockMvcRequestBuilders.get("/api/concurrenmapcache/cache"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn().getResponse().getContentAsString();
        }
    }

    @Test
    public void save() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }


}
