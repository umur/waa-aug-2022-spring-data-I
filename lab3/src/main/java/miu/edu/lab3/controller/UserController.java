package miu.edu.lab3.controller;

import miu.edu.lab3.dto.UserCreateDto;
import miu.edu.lab3.dto.UserDetailsDto;
import miu.edu.lab3.dto.UserDto;
import miu.edu.lab3.repo.UserRepo;
import miu.edu.lab3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired private UserService service;
    @GetMapping
    public ResponseEntity<List<UserDto>> getAll()
    {
        var result = service.getAll();

        return ResponseEntity.status(200).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailsDto> getById(@PathVariable int id)
    {
        return ResponseEntity.status(200).body(service.getById(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody UserCreateDto user)
    {
        service.save(user);
        return ResponseEntity.status(201).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody UserCreateDto user) throws Exception {
        service.update(id, user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDetailsDto> remove(@PathVariable int id)
    {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
