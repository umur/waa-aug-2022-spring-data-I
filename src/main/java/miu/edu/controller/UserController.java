package miu.edu.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.dto.UserDto;
import miu.edu.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto getOne(@PathVariable Integer id) {
        return userService.getOne(id);
    }

    @PostMapping
    public UserDto save(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Integer id) {
        userService.remove(id);
    }
}
