package com.example.waa_lab3.Controller;

import com.example.waa_lab3.DTO.CategoryDto;
import com.example.waa_lab3.Domian.Category;
import com.example.waa_lab3.Service.ICategoryService;
import com.example.waa_lab3.Service.Imp.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {

    @Autowired
   private final ICategoryService categoryService;


    @GetMapping
    public List<CategoryDto> findAll(){

        return categoryService.findAll();
    }


    @GetMapping("/{id}")
    public CategoryDto getCategory(@PathVariable("id") int id){
        return categoryService.getCategory(id);
    }

   @PostMapping
    public CategoryDto addCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.addCategory(categoryDto);
   }

   @PutMapping("/{id}")

    public CategoryDto updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable("id") int id){

        return categoryService.updateCategory(categoryDto, id);
   }

   @DeleteMapping("/{id}")

    public void deleteCategory(@PathVariable("id") int id){

        categoryService.deleteCategory(id);

   }


}
