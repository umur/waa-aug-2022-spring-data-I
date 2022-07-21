package com.lab3.waaaug2022springdatai.jointable_bidir.controller;

import com.lab3.waaaug2022springdatai.jointable_bidir.dto.ProductDto;
import com.lab3.waaaug2022springdatai.jointable_bidir.entity.Product;
import com.lab3.waaaug2022springdatai.jointable_bidir.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController (ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product save(@RequestBody ProductDto productDto) {
        return productService.save(productDto);
    }

    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id) {
        var product = productService.getById(id);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @GetMapping("/filter-by-price")
    public List<Product> getAllByPriceGreaterThan(@RequestParam double minCost) {
        return productService.findAllByPriceGreaterThan(minCost);
    }

    @GetMapping("/category/{categoryId}/filter-by-price")
    public List<Product> getAllByPriceLessThanAndCategory(@RequestParam double maxPrice, @PathVariable int categoryId) {
        return productService.findAllByPriceLessThanAndCategory(maxPrice, categoryId);
    }

    @GetMapping("/search-by-keyword")
    public List<Product> getAllByCategoryContains(@RequestParam String keyword) {
        return productService.findByCategory(keyword);
    }
}
