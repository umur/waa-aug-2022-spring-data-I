package lab.waa.three.databasedemo.controller;

import lab.waa.three.databasedemo.dto.ReviewDto;
import lab.waa.three.databasedemo.dto.ReviewDto;
import lab.waa.three.databasedemo.service.ProductService;
import lab.waa.three.databasedemo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {
  private final ReviewService service;

  @GetMapping
  public ResponseEntity<List<ReviewDto>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ReviewDto> findById(@PathVariable int id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @PostMapping
  public ResponseEntity<Void> save(@RequestBody ReviewDto dto) {

    service.save(dto);
    return new ResponseEntity<Void>(HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable int id, @RequestBody ReviewDto dto) {
    service.update(id, dto);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable int id) {
    service.delete(id);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }
}
