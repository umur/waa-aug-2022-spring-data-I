package com.javokhir.lab3.controller;

import com.javokhir.lab3.dto.CategoryDto;
import com.javokhir.lab3.service.CategoryService;
import com.javokhir.lab3.service.CrudService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController implements CrudController<CategoryDto, Long> {

    private final CategoryService service;

    @Override
    public CrudService<CategoryDto, Long> getService() {
        return service;
    }
}
