package edu.miu.lab3.controller;

import edu.miu.lab3.dto.CategoryDto;
import edu.miu.lab3.dto.ProductDto;
import edu.miu.lab3.service.ICategoryService;
import edu.miu.lab3.service.IProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {

        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryDto> fetchAll() {
        return categoryService.fetchAll();
    }

}
