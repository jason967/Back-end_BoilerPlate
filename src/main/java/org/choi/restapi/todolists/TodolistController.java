package org.choi.restapi.todolists;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodolistController {

    @GetMapping("/hello")
    public String HelloController()
    {
        return "hello";
    }
}
