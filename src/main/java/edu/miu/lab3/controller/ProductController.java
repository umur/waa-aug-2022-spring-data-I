package edu.miu.lab3.controller;

import edu.miu.lab3.domain.Product;
import edu.miu.lab3.dto.ProductDTO;
import edu.miu.lab3.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    ProductService productService;


    @GetMapping
    List<ProductDTO> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    ProductDTO findProductById(@PathVariable int id){
        return productService.findById(id);
    }

    @PostMapping
    Product addProduct(@RequestBody ProductDTO productDTO){
        return productService.addProduct(productDTO);
    }

    @PutMapping
    Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }


}
