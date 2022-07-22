package com.javokhir.lab3.controller;

import com.javokhir.lab3.dto.ProductDto;
import com.javokhir.lab3.dto.ReviewDto;
import com.javokhir.lab3.service.CrudService;
import com.javokhir.lab3.service.ProductService;
import com.javokhir.lab3.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController implements CrudController<ProductDto, Long> {

    private final ProductService service;
    private final ReviewService reviewService;

    @Override
    public CrudService<ProductDto, Long> getService() {
        return service;
    }

    @GetMapping("/find-by-min-price")
    public List<ProductDto> getByMinPrice(@RequestParam("minPrice") Double minPrice) {
        return service.getByMinPrice(minPrice);
    }

    @GetMapping("/find-by-name")
    public List<ProductDto> getByName(@RequestParam("name") String name){
        return service.getByName(name);
    }

    @GetMapping("/{id}/reviews")
    public List<ReviewDto> getReviewsByProduct(@PathVariable("id") Long productId){
        return reviewService.getAllByProductId(productId);
    }
}
