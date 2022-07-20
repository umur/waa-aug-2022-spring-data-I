package miu.edu.lab03.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.lab03.dto.UserDTO;
import miu.edu.lab03.model.User;
import miu.edu.lab03.service.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl service;

    private final ModelMapper mapper;

    @GetMapping
    public List<UserDTO> getAll() {
        return service.getAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(this::toDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public UserDTO save(@RequestBody User user) {
        return this.toDTO(service.save(user));
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return this.toDTO(service.save(user));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    private UserDTO toDTO(User user) {
        return mapper.map(user, UserDTO.class);
    }

    private User toEntity(UserDTO user) {
        return mapper.map(user, User.class);
    }
}
