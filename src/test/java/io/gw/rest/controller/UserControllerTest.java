package io.gw.rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.gw.rest.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// - 1. JUnit with Autowired Inject Constructor
@SpringBootTest
@AutoConfigureMockMvc

// - 2. Annotations that can be LightWeighted
//@WebMvcTest(UserController.class)
class UserControllerTest {
    // Testing with Test Object for Web Environment
    // Can send Get and Post method
    // Inject by Autowired Annotation

    // - 1. JUnit only allows to use Autowired when inject Constructor
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
    }

    // Post Testing and check expected result
    // content Function in andExpect is
    @Test
    void register() throws Exception {
        User sample = User.sample(); // Created Testing User
        String content = objectMapper.writeValueAsString(sample); // Convert to JSON form
        mockMvc.perform(post("/users")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(sample.getId()))
                .andDo(print());

//        return mockMvc.perform();
    }

    @Test
    void find() {
    }

    @Test
    void findAll() {
    }

    @Test
    void modify() {
    }

    @Test
    void remove() {
    }

    @AfterEach
    void tearDown() {
    }
}
