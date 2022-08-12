package com.example.waa_lab3.Controller;


import com.example.waa_lab3.DTO.ProductDto;
import com.example.waa_lab3.Domian.Product;
import com.example.waa_lab3.Domian.Review;
import com.example.waa_lab3.Service.Imp.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable int id) {
        return productService.getProduct(id);
    }

    @PostMapping("/categories/{categoryId}/products")
    public ProductDto addProduct(@PathVariable int categoryId, @RequestBody ProductDto productDto) {
        return productService.addProduct(categoryId, productDto);
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@RequestBody ProductDto productDto, @PathVariable int id) {
        return productService.updateProduct(productDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }


    @GetMapping("/reviews")
    public List<Review> findAllReviewsOfProduct(@RequestParam int productId)
    {
        return productService.findAllReviewsOfProduct(productId);
    }

    @GetMapping("/filter")
    public List<Product> findByPriceGreaterThan(@RequestParam double minPrice)
    {
        return productService.findByPriceGreaterThan(minPrice);
    }

    @GetMapping("/products/searchByName")
    List<ProductDto> findByNameContains(@RequestParam String keyword)
    {
        return productService.findByNameContains(keyword);
    }

    @GetMapping("/filter/{category_id}")
    public List<ProductDto> findByCategoryAndPriceLessThan( @PathVariable int category_id , @RequestParam double maxPrice)
    {
        return productService.findAllByCategoryIdAndPriceLessThanEqual(category_id, maxPrice);
    }
}
