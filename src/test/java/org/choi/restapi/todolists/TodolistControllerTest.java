package org.choi.restapi.todolists;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class TodolistControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createTodolist() throws Exception {
        mockMvc.perform(post("/api/todolist/")
                //요청본문에 JSON을 담아서 보낸다.
                .contentType(MediaType.APPLICATION_JSON)
                //HAL_JSON형식의 응답을 원한다.
                .accept(MediaTypes.HAL_JSON))
                //Response 201이 나오길 기대한다.
                .andExpect(status().isCreated());
    }

}