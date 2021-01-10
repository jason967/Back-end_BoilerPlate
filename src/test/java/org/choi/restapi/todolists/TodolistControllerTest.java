package org.choi.restapi.todolists;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class TodolistControllerTest {
    @Autowired
    private MockMvc mockMvc;

    //TODO  ObjectMapper objectMapper의 역할 정확하게 파악하하기
   @Autowired
    ObjectMapper objectMapper;

    //1. 테스팅을 하면 당연히 실패한다.
    @Test
    public void createTodolist() throws Exception {

        Todolist todolist = Todolist.builder()
                .name("choi")
                .content("content is here")
                .startDate(LocalDateTime.of(2021,01,11,12,00,00))
                .endDate(LocalDateTime.of(2021,01,12,12,00))
                .build();

        mockMvc.perform(post("/api/todolist/")
                //요청본문에 JSON을 담아서 보낸다.
                .contentType(MediaType.APPLICATION_JSON)
                //HAL_JSON형식의 응답을 원한다.
                .accept(MediaTypes.HAL_JSON)
                //todolist객체를 json형식의 string으로 변환해줌-> 요청본문에 넣어줌
                .content(objectMapper.writeValueAsString(todolist)))
                //Response 201이 나오길 기대한다.
                .andExpect(status().isCreated())
                //TODO jsonPath의 용도 파악하기
                //"id"의 값이 존재하는 지 테스팅
                .andExpect(jsonPath("id").exists())
                .andDo(print());
    }

}