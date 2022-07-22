package edu.miu.waa575.lab3springdata.service;

import edu.miu.waa575.lab3springdata.dto.CategoryDto;
import edu.miu.waa575.lab3springdata.dto.ReviewDto;
import edu.miu.waa575.lab3springdata.entity.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();
    CategoryDto findById(int id);
    CategoryDto save(CategoryDto categoryDto);
    Category update(Category category);
    void remove(int reviewId);
}
