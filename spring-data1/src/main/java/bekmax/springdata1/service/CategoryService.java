package bekmax.springdata1.service;

import bekmax.springdata1.dto.CategoryDto;
import bekmax.springdata1.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();

    CategoryDto save(CategoryDto categoryDto);

    CategoryDto get(Long categoryId);

    void delete(Long categoryId);
}
