package edu.miu.lab3.controller;

import edu.miu.lab3.domain.User;
import edu.miu.lab3.dto.UserDTO;
import edu.miu.lab3.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    UserService userService;

    @GetMapping
    List<UserDTO> findAll(){
       return  userService.findAll();
    }

    @GetMapping("/{id}")
    UserDTO findById(@PathVariable Integer id){
        return userService.findById(id);
    }

    @PostMapping
    UserDTO addUser(@RequestBody UserDTO userDTO){
        userService.addUser(userDTO);
        return userDTO;
    }

    @PutMapping
    UserDTO updateUser(@RequestBody User user){
        userService.update(user);
        return null;
    }

    @DeleteMapping("/{id}")
    UserDTO deleteUser(@PathVariable int id){
        return userService.deleteById(id);
    }
}
