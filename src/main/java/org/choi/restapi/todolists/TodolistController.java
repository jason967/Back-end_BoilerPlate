package org.choi.restapi.todolists;


import org.springframework.beans.factory.annotation.Autowired;
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

    //레포지토리를 생성자를 통해 의존성 주입
    private TodolistRepository todolistRepository;

    @Autowired
    public TodolistController(TodolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    @PostMapping
    public ResponseEntity createTodolist(@RequestBody Todolist todolist)
    {
        //저장이 된 객체
        Todolist newTodolist = this.todolistRepository.save(todolist);
        //TODO methodOn의 용도 정확하게 알아보기
        //created를 보낼 URI가 필요함-> 만들어야됌 hateos가 제공하는 linkTo(),methodOn()사용
        URI createdUri = linkTo(TodolistController.class).slash(newTodolist.getId()).toUri();
       return ResponseEntity.created(createdUri).body(todolist);
    }
}
