package com.lab3.waaaug2022springdatai.jointable_bidir.service;

import com.lab3.waaaug2022springdatai.jointable_bidir.dto.CategoryDto;
import com.lab3.waaaug2022springdatai.jointable_bidir.entity.Category;

import java.util.List;

public interface CategoryService {
    Category save(CategoryDto categoryDto);

    void delete(int id);

    Category getById(int id);

    List<Category> getAll();

    Category updateCategory(Category category);
}
