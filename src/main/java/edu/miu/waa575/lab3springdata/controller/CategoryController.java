package edu.miu.waa575.lab3springdata.controller;

import edu.miu.waa575.lab3springdata.dto.AddressDto;
import edu.miu.waa575.lab3springdata.dto.CategoryDto;
import edu.miu.waa575.lab3springdata.entity.Address;
import edu.miu.waa575.lab3springdata.entity.Category;
import edu.miu.waa575.lab3springdata.service.AddressService;
import edu.miu.waa575.lab3springdata.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private  final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public  CategoryDto findById(@PathVariable int id){
        return categoryService.findById(id);
    }

    @PostMapping
    public CategoryDto save(@RequestBody CategoryDto categoryDto){
        return categoryService.save(categoryDto);
    }

    @PutMapping
    public Category update(@RequestBody Category category){
        return categoryService.update(category);
    }

    @DeleteMapping("/{id}")
    public  void remove(@PathVariable int id){
        categoryService.remove(id);
    }

}
