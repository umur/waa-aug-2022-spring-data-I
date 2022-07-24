package lab.waa.three.databasedemo.controller;

import lab.waa.three.databasedemo.dto.ProductDto;
import lab.waa.three.databasedemo.dto.ProductDto;
import lab.waa.three.databasedemo.service.CategoryService;
import lab.waa.three.databasedemo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
  private final ProductService service;

  @GetMapping
  public ResponseEntity<List<ProductDto>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductDto> findById(@PathVariable int id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @PostMapping
  public ResponseEntity<Void> save(@RequestBody ProductDto dto) {

    service.save(dto);
    return new ResponseEntity<Void>(HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable int id, @RequestBody ProductDto dto) {
    service.update(id, dto);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable int id) {
    service.delete(id);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }
}
