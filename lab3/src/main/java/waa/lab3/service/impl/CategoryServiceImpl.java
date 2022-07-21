package waa.lab3.service.impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import waa.lab3.dto.CategoryDto;
import waa.lab3.entity.Category;
import waa.lab3.repository.CategoryRepo;
import waa.lab3.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    private final ModelMapper modelMapper;

    @Override
    public List<CategoryDto> findAll() {
        var result = new ArrayList<CategoryDto>();
        categoryRepo.findAll().forEach(category -> result.add(modelMapper.map(category, CategoryDto.class)));
        return result;
    }

    @Override
    public CategoryDto findById(int id) {
        return modelMapper.map(categoryRepo.findById(id).get(), CategoryDto.class);
    }

    @Override
    public void deleteById(int id) {
        categoryRepo.deleteById(id);
    }

    @Override
    public void saveCategory(CategoryDto category) {
        categoryRepo.save(modelMapper.map(category, Category.class));
    }
}
