package miu.edu.lab3.service;

import miu.edu.lab3.dto.*;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAll();
    CategoryDetailsDto getById(int id);
    void save(CategoryCreateDto cat);
    void delete(int id);
    void update(int id, CategoryCreateDto categoryCreateDto) throws Exception;
}
