package com.javokhir.lab3.controller;

import com.javokhir.lab3.dto.CategoryDto;
import com.javokhir.lab3.dto.ProductDto;
import com.javokhir.lab3.service.CategoryService;
import com.javokhir.lab3.service.CrudService;
import com.javokhir.lab3.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController implements CrudController<CategoryDto, Long> {

    private final CategoryService service;
    private final ProductService productService;

    @Override
    public CrudService<CategoryDto, Long> getService() {
        return service;
    }

    @GetMapping("/{id}/products/find-by-max-price")
    public List<ProductDto> getAllProductsByCategoryAndMaxPrice(@PathVariable("id") Long categoryId,
            @RequestParam("maxPrice") double maxPrice) {
            return productService.getByCategoryAndMaxPrice(categoryId, maxPrice);
    }
}
