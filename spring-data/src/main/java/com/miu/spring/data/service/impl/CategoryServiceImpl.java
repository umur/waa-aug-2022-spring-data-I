package com.miu.spring.data.service.impl;

import com.miu.spring.data.entity.Category;
import com.miu.spring.data.repository.CategoryRepository;
import com.miu.spring.data.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categeryRepository;
    @Override
    public List<Category> getAllCategories(){
        return categeryRepository.findAll();
    }
    @Override
    public Optional<Category> getCategoryById(int id){
        return categeryRepository.findById(id);
    }
    @Override
    public Category saveCategory(Category category){
        return categeryRepository.save(category);
    }
    public void deleteCategory(int id){
         categeryRepository.deleteById(id);
        System.out.println("deleted");
    }

}
