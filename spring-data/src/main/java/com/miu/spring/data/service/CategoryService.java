package com.miu.spring.data.service;

import com.miu.spring.data.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface CategoryService {
    public List<Category> getAllCategories();
    public void deleteCategory(int id);
    public Category saveCategory(Category category);
    public Optional<Category> getCategoryById(int id);
}
