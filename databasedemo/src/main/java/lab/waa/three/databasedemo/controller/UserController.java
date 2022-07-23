package lab.waa.three.databasedemo.controller;

import lab.waa.three.databasedemo.dto.UserDto;
import lab.waa.three.databasedemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping
  public ResponseEntity<List<UserDto>> findAll() {
    return ResponseEntity.ok(userService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDto> findById(@PathVariable int id) {
    return ResponseEntity.ok(userService.findById(id));
  }

  @PostMapping
  public ResponseEntity<Void> save(@RequestBody UserDto userDto) {

    userService.save(userDto);
    return new ResponseEntity<Void>(HttpStatus.CREATED);
  }
}
