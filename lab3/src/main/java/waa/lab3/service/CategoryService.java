package waa.lab3.service;

import waa.lab3.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAll();

    CategoryDto findById(int id);

    void deleteById(int id);

    void saveCategory(CategoryDto category);
}
