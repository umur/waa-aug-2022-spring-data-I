package edu.miu.lab3springdata.controller;

import edu.miu.lab3springdata.dto.ProductDto;
import edu.miu.lab3springdata.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public void save(@RequestBody ProductDto productDto) {
        productService.save(productDto);
    }

    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable int id) {
        return productService.findById(id);
    }

    @GetMapping("/search")
    public List<ProductDto> searchProducts(@RequestParam Map<String, String> params) {
        if(params.containsKey("minPrice")) {
            var minPrice = Float.parseFloat(params.get("minPrice"));
            return productService.findAllByPriceGreaterThanEqual(minPrice);
        } else if(params.containsKey("maxPrice") && params.containsKey("categoryId")) {
            var categoryId = Integer.parseInt(params.get("categoryId"));
            var maxPrice = Float.parseFloat(params.get("maxPrice"));
            return productService.findAllByCategoryIdAndPriceLessThanEqual(categoryId, maxPrice);
        } else if(params.containsKey("keyword")) {
            return productService.findAllByNameIsLikeIgnoreCase(params.get("keyword"));
        }
        return null;
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody ProductDto productDto) {
        productDto.setId(id);
        productService.update(productDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }
}
