package edu.miu.waa575.lab3springdata.controller;


import edu.miu.waa575.lab3springdata.dto.ProductDto;
import edu.miu.waa575.lab3springdata.entity.Product;
import edu.miu.waa575.lab3springdata.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private  final ProductService productService;

    @GetMapping
    public List<ProductDto> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public  ProductDto findById(@PathVariable int id){
        return productService.findById(id);
    }

    @PostMapping
    public ProductDto save(@RequestBody ProductDto productDto){
        return productService.save(productDto);
    }

    @PutMapping
    public Product update(@RequestBody Product product){
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    public  void remove(@PathVariable int id){
        productService.remove(id);
    }


    //FILTERS
    @GetMapping("/filterByMinPrice")
    public List<ProductDto> filterByMinPrice(@RequestParam Double price) {
        return productService.filterByMinPrice(price);
    }

    @GetMapping("/filterByCategoryMaxPrice")
    public List<ProductDto> filterByCatAndMaxPrice(@RequestParam Integer catId, @RequestParam Double price) {
        return productService.filterByCatAndMaxPrice(catId, price);
    }

    @GetMapping("/filterByKeyword")
    public List<ProductDto> filterByKeyword(@RequestParam String keyword) {
        return productService.filterByKeyword(keyword);
    }

}