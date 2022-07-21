package miu.edu.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.dto.CategoryDto;
import miu.edu.entity.Category;
import miu.edu.repository.CategoryRepository;
import miu.edu.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(this::categoryToDto).collect(Collectors.toList());
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        categoryRepository.save(dtoToCategory(categoryDto));
        return categoryDto;
    }

    @Override
    public CategoryDto getOne(int categoryId) {
        return categoryRepository.findById(categoryId).map(this::categoryToDto).orElse(null);
    }

    @Override
    public void remove(int categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    private CategoryDto categoryToDto(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }

    private Category dtoToCategory(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }

}
