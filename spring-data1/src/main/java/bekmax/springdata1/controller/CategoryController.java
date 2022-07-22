package bekmax.springdata1.controller;

import bekmax.springdata1.dto.CategoryDto;
import bekmax.springdata1.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDto get(@PathVariable Long id){
        return categoryService.get(id);
    }

    @PostMapping
    public CategoryDto save(@RequestBody CategoryDto categoryDto){
        return categoryService.save(categoryDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        categoryService.delete(id);
    }
}
