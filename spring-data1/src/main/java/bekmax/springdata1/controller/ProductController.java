package bekmax.springdata1.controller;

import bekmax.springdata1.dto.ProductDto;
import bekmax.springdata1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductDto get(@PathVariable Long id) {
        return productService.get(id);
    }

    @PostMapping
    public ProductDto save(@RequestBody ProductDto productDto) {
        return productService.save(productDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    //getByMinPrice
    @GetMapping("/filter-price")
    public List<ProductDto> filterByMinPrice(@RequestParam Double minPrice){
        System.out.println(minPrice);
        return productService.filterByGreaterThanMinPrice(minPrice);
    }

    //getByCategoryAndMaxPrice
    @GetMapping("/filter-category-price")
    public List<ProductDto> filterByCategoryAndMaxPrice(@RequestParam Long categoryId, @RequestParam Double maxPrice){
        return productService.filterByCategoryAndLessThanMaxPrice(categoryId, maxPrice);
    }

    //getByKeyword
    @GetMapping("/filter-keyword")
    public List<ProductDto> filterByKeyword(@RequestParam String keyword){
        return productService.filterByKeyword(keyword);
    }
}
