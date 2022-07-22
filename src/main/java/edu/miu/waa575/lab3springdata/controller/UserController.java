package edu.miu.waa575.lab3springdata.controller;

import edu.miu.waa575.lab3springdata.dto.UserDto;
import edu.miu.waa575.lab3springdata.entity.User;
import edu.miu.waa575.lab3springdata.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private  final UserService userService;

    @GetMapping
    public List<UserDto> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public  UserDto findById(@PathVariable int id){
        return userService.findById(id);
    }

    @PostMapping
    public UserDto save(@RequestBody UserDto userDtoDto){
        return userService.save(userDtoDto);
    }

    @PutMapping
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public  void remove(@PathVariable int id){
        userService.remove(id);
    }

}