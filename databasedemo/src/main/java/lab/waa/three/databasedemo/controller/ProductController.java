package lab.waa.three.databasedemo.controller;

import lab.waa.three.databasedemo.dto.ProductDto;
import lab.waa.three.databasedemo.dto.ProductDto;
import lab.waa.three.databasedemo.dto.ReviewDto;
import lab.waa.three.databasedemo.service.CategoryService;
import lab.waa.three.databasedemo.service.ProductService;
import lab.waa.three.databasedemo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
  private final ProductService service;
  private final ReviewService reviewService;

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

  @GetMapping("/filter")
  public ResponseEntity<List<ProductDto>> filter(@RequestParam Map<String, String> args) {
    if(args.containsKey("minPrice")){
      return ResponseEntity.ok(service.findProductByPriceGreaterThan(Double.parseDouble(args.get("minPrice"))));
    }
    if(args.containsKey("maxPrice") && args.containsKey("categoryName")) {
      return ResponseEntity.ok(service.findProductByCategoryIdAndPriceLessThan(args.get("categoryName"), Double.parseDouble(args.get("maxPrice"))));
    }

    if(args.containsKey("keyword")) {
      return ResponseEntity.ok(service.findProductByCategoryNameContains(String.valueOf(args.get("keyword"))));
    }

    return ResponseEntity.ok(new ArrayList<ProductDto>());
  }

  @GetMapping("/{productId}/reviews")
  public ResponseEntity<List<ReviewDto>> filter(@PathVariable int productId) {

    return ResponseEntity.ok(reviewService.findReviewsByProductId(productId));
  }
}
