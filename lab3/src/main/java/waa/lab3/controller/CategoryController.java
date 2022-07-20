package waa.lab3.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import waa.lab3.dto.CategoryDto;
import waa.lab3.service.CategoryService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @PostMapping
    public void addCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.saveCategory(categoryDto);
    }

    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable int id) {
        return categoryService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        categoryService.deleteById(id);
    }
}
