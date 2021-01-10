package org.choi.restapi.todolists;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class TodolistTest {
    @Test
    public void builder()
    {
        Todolist todolist = Todolist.builder()
                .name("choi")
                .content("content is here")
                .build();
        assertThat(todolist).isNotNull();
    }

    //지라연동테스트 다시 제발 좀 되라
    @Test
    public void javaBean()
    {
        //Given
        String name = "choi";
        String contents = "content is here";

        //When
        Todolist todolist = new Todolist();
        todolist.setName(name);
        todolist.setContent(contents);

        //Then
        assertThat(todolist.getName()).isEqualTo(name);
        assertThat(todolist.getContent()).isEqualTo(contents);
    }
}
