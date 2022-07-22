package edu.miu.lab3.joincolumn_bidir.service;

import edu.miu.lab3.joincolumn_bidir.dto.CategoryDto;
import edu.miu.lab3.joincolumn_bidir.entity.Category;

import java.util.List;

public interface CategoryService {
    Category save(CategoryDto categoryDto);

    void delete(int id);

    Category getById(int id);

    List<Category> getAll();

    Category updateCategory(Category category);
}
