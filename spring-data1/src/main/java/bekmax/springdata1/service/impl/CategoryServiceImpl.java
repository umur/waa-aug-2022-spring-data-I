package bekmax.springdata1.service.impl;

import bekmax.springdata1.dto.CategoryDto;
import bekmax.springdata1.model.Category;
import bekmax.springdata1.repository.CategoryRepository;
import bekmax.springdata1.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(this::convertCategoryToDto).toList();
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        Category category = categoryRepository.save(convertDtoToCategory(categoryDto));
        categoryDto.setId(category.getId());
        return categoryDto;
    }

    @Override
    public CategoryDto get(Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        return category.map(this::convertCategoryToDto).orElse(null);
    }

    @Override
    public void delete(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    private CategoryDto convertCategoryToDto(Category category) {
        return new CategoryDto(category.getId(), category.getName());
    }

    private Category convertDtoToCategory(CategoryDto categoryDto) {
        return new Category(categoryDto.getId(), categoryDto.getName());
    }
}
