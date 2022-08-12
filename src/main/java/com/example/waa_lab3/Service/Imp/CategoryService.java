package com.example.waa_lab3.Service.Imp;

import com.example.waa_lab3.DTO.CategoryDto;
import com.example.waa_lab3.Domian.Address;
import com.example.waa_lab3.Domian.Category;
import com.example.waa_lab3.Domian.Product;
import com.example.waa_lab3.Repository.CategoryRepository;
import com.example.waa_lab3.Service.ICategoryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CategoryService implements ICategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public List<CategoryDto> findAll() {
        var categories = categoryRepository.findAll();
        var result = new ArrayList<CategoryDto>();

        for(Category category : categories){

            CategoryDto categoryDto = new CategoryDto();
            categoryDto = modelMapper.map(category, CategoryDto.class);
            result.add(categoryDto);
        }
        return result;
    }

    @Override
    public CategoryDto getCategory(int id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null){

            CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
            return categoryDto;

        }

        return null;
    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
       Category category = modelMapper.map(categoryDto, Category.class);
       Category category1 = categoryRepository.save(category);
       CategoryDto categoryDto1 = modelMapper.map(category1, CategoryDto.class);


        return categoryDto1;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, int id) {
        Category category = categoryRepository.findById(id).orElse(null);

        if(category != null ) {
            Category category1 = modelMapper.map(categoryDto, Category.class);
            Category category2 = categoryRepository.save(category1);
            CategoryDto categoryDto1 = modelMapper.map(category2, CategoryDto.class);

          return  categoryDto1;
        }

        return null;
    }


    @Override
    public void deleteCategory(int id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            categoryRepository.delete(category);
        }
    }
}
