package edu.miu.demo.spring.data.lab3.Controllers;

import edu.miu.demo.spring.data.lab3.dtos.AddressDto;
import edu.miu.demo.spring.data.lab3.dtos.CategoryDto;
import edu.miu.demo.spring.data.lab3.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> getAllCategories(){
        return categoryService.getAll();
    }

    @PostMapping
    public ResponseEntity addCategory(@RequestBody CategoryDto categoryDto){
        categoryService.save(categoryDto);
        return new ResponseEntity("Added category successfully", HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity deleteCategory(@RequestParam String id){
        categoryService.delete(Integer.parseInt(id));
        return new ResponseEntity("Deleted category",HttpStatus.NO_CONTENT);
    }
}
