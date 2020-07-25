package me.zw.purplebook.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void expect_hello() throws Exception {
        String hello = "hello";
        mockMvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));
    }

    @Test
    public void expect_helloDto() throws Exception {
        String name = "hello";
        int amount = 1000;

        mockMvc.perform(
                get("/hello/dto").param("name", name).param("amount", String.valueOf(1000)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.amount").value(amount));
    }


}
