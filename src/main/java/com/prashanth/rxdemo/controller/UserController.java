package com.prashanth.rxdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.prashanth.rxdemo.model.User;
import com.prashanth.rxdemo.service.UserService;

import reactor.core.publisher.Flux;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    
    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "/users/flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> getFluxUsers() {
        return userService.getFluxUsers();
    }

}
