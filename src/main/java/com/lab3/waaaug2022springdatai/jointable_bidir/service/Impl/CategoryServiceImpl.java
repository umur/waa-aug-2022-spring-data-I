package com.lab3.waaaug2022springdatai.jointable_bidir.service.Impl;

import com.lab3.waaaug2022springdatai.jointable_bidir.dto.CategoryDto;
import com.lab3.waaaug2022springdatai.jointable_bidir.entity.Category;
import com.lab3.waaaug2022springdatai.jointable_bidir.repository.CategoryRepository;
import com.lab3.waaaug2022springdatai.jointable_bidir.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final ModelMapper modelMapper;

    @Override
    public Category save(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        return categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category getById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }
}
