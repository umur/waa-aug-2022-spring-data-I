package edu.miu.lab3springdata.controller;

import edu.miu.lab3springdata.dto.UserDto;
import edu.miu.lab3springdata.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public void save(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable int id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody UserDto userDto) {
        userDto.setId(id);
        userService.update(userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }
}

