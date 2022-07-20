package com.miu.Lab3.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miu.Lab3.entity.Category;
import com.miu.Lab3.service.CategoryService;
import com.miu.Lab3.repository.CategoryRepository;



/**
 * @author laithnassar
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    
    
    @Autowired
    private CategoryRepository CategoryRepository;

    @Override
    public List<Category> findAll() {
        var result = new ArrayList<Category>();
        CategoryRepository.findAll().forEach(s -> result.add(s));
        return result;
        
    }    
    
    

}
