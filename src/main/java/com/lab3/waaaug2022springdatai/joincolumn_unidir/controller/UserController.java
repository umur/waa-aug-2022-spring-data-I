package com.lab3.waaaug2022springdatai.joincolumn_unidir.controller;

import com.lab3.waaaug2022springdatai.joincolumn_unidir.dto.ReviewDto;
import com.lab3.waaaug2022springdatai.joincolumn_unidir.dto.UserDto;
import com.lab3.waaaug2022springdatai.joincolumn_unidir.entity.User;
import com.lab3.waaaug2022springdatai.joincolumn_unidir.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User save(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable int id) {
        var user = userService.getById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @PostMapping("/review")
    public ReviewDto createReview(@RequestBody ReviewDto reviewDto){
        return userService.createUserReview(reviewDto);
    }
}
