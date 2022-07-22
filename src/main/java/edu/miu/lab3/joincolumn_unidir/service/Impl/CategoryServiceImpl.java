package edu.miu.lab3.joincolumn_unidir.service.Impl;

import edu.miu.lab3.joincolumn_unidir.dto.CategoryDto;
import edu.miu.lab3.joincolumn_unidir.entity.Category;
import edu.miu.lab3.joincolumn_unidir.repository.CategoryRepository;
import edu.miu.lab3.joincolumn_unidir.service.CategoryService;
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
