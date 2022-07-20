package com.miu.Lab3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miu.Lab3.entity.User;
import com.miu.Lab3.service.UserService;


@RestController("/User")
public class UserController {

    @Autowired
    private UserService UserService;

    @GetMapping("/user")
    public List<User> findAll() {
        return UserService.findAll();
    }


}
