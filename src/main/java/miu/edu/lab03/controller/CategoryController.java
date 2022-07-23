package miu.edu.lab03.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.lab03.dto.CategoryDTO;
import miu.edu.lab03.model.Category;
import miu.edu.lab03.service.CategoryServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryServiceImpl service;

    private final ModelMapper mapper;

    @GetMapping
    public List<CategoryDTO> getAll() {
        return service.getAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(this::toDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public CategoryDTO save(@RequestBody Category category) {
        return this.toDTO(service.save(category));
    }

    @PutMapping("/{id}")
    public CategoryDTO update(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        return this.toDTO(service.save(category));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    private CategoryDTO toDTO(Category category) {
        return mapper.map(category, CategoryDTO.class);
    }

    private Category toEntity(CategoryDTO category) {
        return mapper.map(category, Category.class);
    }
}
