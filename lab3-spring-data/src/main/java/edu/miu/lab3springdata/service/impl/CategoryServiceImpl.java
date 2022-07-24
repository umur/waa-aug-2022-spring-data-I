package edu.miu.lab3springdata.service.impl;

import edu.miu.lab3springdata.dto.CategoryDto;
import edu.miu.lab3springdata.entity.Category;
import edu.miu.lab3springdata.repository.CategoryRepo;
import edu.miu.lab3springdata.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(CategoryDto categoryDto) {
        categoryRepo.save(modelMapper.map(categoryDto, Category.class));
    }

    @Override
    public List<CategoryDto> findAll() {
        var categories = new ArrayList<CategoryDto>();
        categoryRepo.findAll().forEach(c -> categories.add(modelMapper.map(c, CategoryDto.class)));
        return categories;
    }

    @Override
    public CategoryDto findById(int id) {
        var category = categoryRepo.findById(id).orElse(null);
        return category != null ? modelMapper.map(category, CategoryDto.class) : null;
    }

    @Override
    public void update(CategoryDto categoryDto) {
        if(categoryRepo.existsById(categoryDto.getId()))
            save(categoryDto);
    }

    @Override
    public void delete(int id) {
        var category = categoryRepo.findById(id).orElse(null);
        if(category != null)
            categoryRepo.delete(category);
    }
}
