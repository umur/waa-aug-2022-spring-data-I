package com.miu.spring.data.Controller;

import com.miu.spring.data.dto.ProductDto;
import com.miu.spring.data.entity.Category;
import com.miu.spring.data.entity.Product;
import com.miu.spring.data.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ModelMapper mapper;
    @GetMapping("/getAll")
    public List<ProductDto> getProducts(){
        return productService.getAllProduct().stream().map(this::toDto).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable Integer id){
        return productService.getProductById(id).map(this::toDto).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @PostMapping
    public ProductDto saveProduct(@RequestBody Product product){
        return this.toDto(productService.saveProduct(product));
    }
    @PutMapping("/{id}")
    public ProductDto update(@PathVariable int id, @RequestBody Product product){
        product.setId(id);
        return this.toDto(productService.saveProduct(product));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        productService.delete(id);
    }
    //localhost:8081/products/min-price?price=200
    @GetMapping("/min-price")
    public List<ProductDto> getByMinPrice(@RequestParam double price){
        return productService.findProductsByPriceGreaterThan(price).stream().map(this::toDto).collect(Collectors.toList());
    }
    @GetMapping()
    public List<Product> getCategoryAndPrice(@RequestParam Category category, double price){
        return productService.findProductsByCategoryAndPriceLessThan(category, price);
    }

    private ProductDto toDto(Product product){
        return mapper.map(product, ProductDto.class);
    }
    private Product toEntity(ProductDto productDto){
        return mapper.map(productDto, Product.class);
    }

}
