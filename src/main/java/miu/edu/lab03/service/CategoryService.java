package miu.edu.lab03.service;

import miu.edu.lab03.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAll();
    Optional<Category> getById(Long id);
    Category save(Category category);
    void delete(Long id);
}
