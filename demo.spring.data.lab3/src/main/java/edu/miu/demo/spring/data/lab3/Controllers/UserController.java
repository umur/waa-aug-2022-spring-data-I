package edu.miu.demo.spring.data.lab3.Controllers;

import edu.miu.demo.spring.data.lab3.dtos.UserDto;
import edu.miu.demo.spring.data.lab3.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getAllUsers(){
        return userService.getAll();
    }
}
