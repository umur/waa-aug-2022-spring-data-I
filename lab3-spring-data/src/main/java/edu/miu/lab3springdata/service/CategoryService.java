package edu.miu.lab3springdata.service;

import edu.miu.lab3springdata.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    public void save(CategoryDto categoryDto);
    public List<CategoryDto> findAll();
    public CategoryDto findById(int id);
    public void update(CategoryDto categoryDto);
    public void delete(int id);
}
