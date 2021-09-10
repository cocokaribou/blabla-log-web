package com.cocokaribou.blabla_lee.springboot.web;

import com.cocokaribou.blabla_lee.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // junit에 내장된 실행자외 다른 실행자 실행시킴, 스프링부트와 junit의 연결자
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired // bean 주입
    private MockMvc mvc; // 웹 api 테스트

    @Test //
    public void return_hello() throws Exception {
        String hello = "hello";
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }
}