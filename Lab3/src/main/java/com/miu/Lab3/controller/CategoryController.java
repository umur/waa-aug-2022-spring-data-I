package com.miu.Lab3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miu.Lab3.entity.Category;
import com.miu.Lab3.service.CategoryService;


@RestController("/Category")
public class CategoryController {

    @Autowired
    private CategoryService CategoryService;

    @GetMapping("/Categories")
    public List<Category> findAll() {
        return CategoryService.findAll();
    }


}
