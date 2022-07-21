package com.lab3.waaaug2022springdatai.jointable_bidir.controller;

import com.lab3.waaaug2022springdatai.jointable_bidir.dto.CategoryDto;
import com.lab3.waaaug2022springdatai.jointable_bidir.entity.Category;
import com.lab3.waaaug2022springdatai.jointable_bidir.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController (CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category save(@RequestBody CategoryDto categoryDto) {
        return categoryService.save(categoryDto);
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable int id) {
        var category = categoryService.getById(id);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        categoryService.delete(id);
    }

    @PutMapping
    public Category update(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }
}
