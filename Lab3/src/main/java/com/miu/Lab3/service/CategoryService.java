package com.miu.Lab3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.miu.Lab3.entity.Category;


/**
 * @author laithnassar
 *
 */

public interface CategoryService {
    
    List<Category> findAll();
    

}
