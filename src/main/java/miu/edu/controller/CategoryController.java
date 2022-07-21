package miu.edu.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.dto.CategoryDto;
import miu.edu.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDto getOne(@PathVariable Integer id) {
        return categoryService.getOne(id);
    }

    @PostMapping
    public CategoryDto save(@RequestBody CategoryDto categoryDto) {
        return categoryService.save(categoryDto);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Integer id) {
        categoryService.remove(id);
    }
}
