package edu.miu.lab3.controller;

import edu.miu.lab3.dto.ProductDto;
import edu.miu.lab3.service.IProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> fetchAll() {
        return productService.fetchAll();
    }

    @GetMapping("/filter-by-price-greater-than")
    public List<ProductDto> findAllByPriceGreaterThan(@RequestParam double price) {
        return productService.findAllByPriceGreaterThan(price);
    }

    @GetMapping("/filter-by-category-and-price-less-than")
    public List<ProductDto> findAllByCategoryAndPriceLessThan(@RequestParam String category,@RequestParam double price){
        return productService.findAllByCategoryAndPriceLessThan(category,price);
    }
    @GetMapping("/filter-by-name-contains-keyword")
    public List<ProductDto> findAllByNameContainingIgnoreCase(@RequestParam String keyword) {
        return productService.findAllByNameContainingIgnoreCase(keyword);
    }

}
