package lab.waa.three.databasedemo.controller;

import lab.waa.three.databasedemo.dto.AddressDto;
import lab.waa.three.databasedemo.dto.AddressDto;
import lab.waa.three.databasedemo.service.AddressService;
import lab.waa.three.databasedemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
public class AddressController {
  private final AddressService service;

  @GetMapping
  public ResponseEntity<List<AddressDto>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<AddressDto> findById(@PathVariable int id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @PostMapping
  public ResponseEntity<Void> save(@RequestBody AddressDto dto) {

    service.save(dto);
    return new ResponseEntity<Void>(HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable int id, @RequestBody AddressDto dto) {
    service.update(id, dto);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable int id) {
    service.delete(id);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }
}
