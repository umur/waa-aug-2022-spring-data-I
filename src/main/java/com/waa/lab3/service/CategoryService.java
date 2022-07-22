package com.waa.lab3.service;

import com.waa.lab3.dto.CategoryDTO;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryDTO> findAll();

    Optional<CategoryDTO> findById(Integer id);

    void save(CategoryDTO categoryDTO);

    void deleteById(Integer id);
}
