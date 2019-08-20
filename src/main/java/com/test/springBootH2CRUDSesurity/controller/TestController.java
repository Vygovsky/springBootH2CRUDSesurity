package com.test.springBootH2CRUDSesurity.controller;

import com.test.springBootH2CRUDSesurity.modal.User;
import com.test.springBootH2CRUDSesurity.repository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private UserCrudRepository repository;

    @Autowired
    public TestController(UserCrudRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello, world!";
    }

    @GetMapping(value="/all_users")
    public Iterable<User> allUsers() {
        return repository.findAll();
    }

}
