package edu.miu.waa575.lab3springdata.service.impl;

import edu.miu.waa575.lab3springdata.dto.AddressDto;
import edu.miu.waa575.lab3springdata.dto.CategoryDto;
import edu.miu.waa575.lab3springdata.dto.ReviewDto;
import edu.miu.waa575.lab3springdata.entity.Address;
import edu.miu.waa575.lab3springdata.entity.Category;
import edu.miu.waa575.lab3springdata.repository.CategoryRepository;
import edu.miu.waa575.lab3springdata.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(int id) {
        return categoryRepository.findById(id).map(this::toDto).orElse(null);
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        categoryRepository.save(dtoToEntity(categoryDto));
        return  categoryDto;
    }


    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void remove(int id) {
        categoryRepository.deleteById(id);
    }


    //MappeR
    private CategoryDto toDto(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }

    private Category dtoToEntity(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }
}
