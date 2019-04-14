package com.example.hz.demospringboot;

import com.example.hz.demospringboot.controller.HelloController;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.file.Paths;

/**
 * @Classname HelloControllerTest
 * @Description TODO
 * @Date 2019-03-16 12:21
 * @Created by hzong
 */
public class HelloControllerTest {
    
    private MockMvc mvc;


    //初始化执行
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    //验证controller是否正常响应并打印返回结果
    @Test
    public void getHello() throws Exception {



        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    //验证controller是否正常响应并判断返回结果是否正确
    @Test
    public void testHello() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/v1/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("Hello Spring Boot!")));
    }



}
