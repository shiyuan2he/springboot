package com.hsy.springboot.swagger.web;
import com.hsy.springboot.swagger.SpringBootSwaggerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootSwaggerApplication.class)
@WebMvcTest
public class BookControllerTest {
    @Autowired private MockMvc mockMvc ;

    @Test
    public void jsonTest() throws Exception {
        for (int i = 0; i < 10; i++) {
            this.mockMvc.perform(
                    MockMvcRequestBuilders.get("/api/books/hi")
                            // .params(null)
                            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
            ).andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn().getResponse().getContentAsString()
            ;
        }
    }

}
