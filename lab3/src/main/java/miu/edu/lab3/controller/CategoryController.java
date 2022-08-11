package miu.edu.lab3.controller;

import miu.edu.lab3.dto.*;
import miu.edu.lab3.entity.Category;
import miu.edu.lab3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAll()
    {
        var result = service.getAll();

        return ResponseEntity.status(200).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDetailsDto> getById(@PathVariable int id)
    {
        return ResponseEntity.status(200).body(service.getById(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CategoryCreateDto create)
    {
        service.save(create);
        return ResponseEntity.status(201).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody CategoryCreateDto cat) throws Exception {
        service.update(id, cat);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable int id)
    {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("/{id}/products")
    public EntityResponse<Category> getProducts(@PathVariable int id){
        return null;
    }



}
