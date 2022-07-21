package com.javokhir.lab3.controller;

import com.javokhir.lab3.dto.UserDto;
import com.javokhir.lab3.service.CrudService;
import com.javokhir.lab3.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController implements CrudController<UserDto, Long> {

    private final UserService service;

    @Override
    public CrudService<UserDto, Long> getService() {
        return service;
    }
}
