package edu.miu.lab3springdata.controller;

import edu.miu.lab3springdata.dto.CategoryDto;
import edu.miu.lab3springdata.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public void save(@RequestBody CategoryDto categoryDto) {
        categoryService.save(categoryDto);
    }

    @GetMapping
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable int id) {
        return categoryService.findById(id);
    }


    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody CategoryDto categoryDto) {
        categoryDto.setId(id);
        categoryService.update(categoryDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        categoryService.delete(id);
    }
}
