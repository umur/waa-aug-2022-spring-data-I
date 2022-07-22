package bekmax.springdata1.controller;

import bekmax.springdata1.dto.UserDto;
import bekmax.springdata1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto get(@PathVariable Long id){
        return userService.get(id);
    }

    @PostMapping
    public UserDto save(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

}
