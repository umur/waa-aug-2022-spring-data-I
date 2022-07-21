package miu.edu.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.dto.ProductDto;
import miu.edu.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductDto getOne(@PathVariable Integer id) {
        return productService.getOne(id);
    }

    @PostMapping
    public ProductDto save(@RequestBody ProductDto productDto) {
        return productService.save(productDto);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Integer id) {
        productService.remove(id);
    }

    @GetMapping("/filter-by-min-price")
    public List<ProductDto> filterByMinPrice(@RequestParam Double price) {
        return productService.filterByMinPrice(price);
    }

    @GetMapping("/filter-by-category-max-price")
    public List<ProductDto> filterByCatAndMaxPrice(@RequestParam Integer catId, @RequestParam Double price) {
        return productService.filterByCatAndMaxPrice(catId, price);
    }

    @GetMapping("/filter-by-keyword")
    public List<ProductDto> filterByKeyword(@RequestParam String keyword) {
        return productService.filterByKeyword(keyword);
    }
}
