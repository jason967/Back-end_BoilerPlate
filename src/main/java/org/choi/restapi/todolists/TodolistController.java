package org.choi.restapi.todolists;


import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
//HAL_JSON형식으로 응답을 보낸다.
@RequestMapping(value ="/api/todolist" ,produces = MediaTypes.HAL_JSON_VALUE)
public class TodolistController {

    @PostMapping
    public ResponseEntity createTodolist(@RequestBody Todolist todolist)
    {
        //TODO methodOn의 용도 정확하게 알아보기
        //created를 보낼 URI가 필요함-> 만들어야됌 hateos가 제공하는 linkTo(),methodOn()사용
        URI createdUri = linkTo(TodolistController.class).slash("{id}").toUri();
        todolist.setId(10L);
       return ResponseEntity.created(createdUri).body(todolist);
    }
}
