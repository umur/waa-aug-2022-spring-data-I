package com.javokhir.lab3.controller;

import com.javokhir.lab3.dto.ProductDto;
import com.javokhir.lab3.service.CrudService;
import com.javokhir.lab3.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController implements CrudController<ProductDto, Long> {

    private final ProductService service;

    @Override
    public CrudService<ProductDto, Long> getService() {
        return service;
    }
}
