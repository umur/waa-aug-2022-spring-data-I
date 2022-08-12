package com.example.waa_lab3.Service;

import com.example.waa_lab3.DTO.CategoryDto;
import com.example.waa_lab3.Domian.Category;
import com.example.waa_lab3.Domian.Product;

import java.util.List;

public interface ICategoryService {

    List<CategoryDto> findAll();
    CategoryDto getCategory(int id);
    CategoryDto addCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto, int ic);
    void deleteCategory(int id);

}
