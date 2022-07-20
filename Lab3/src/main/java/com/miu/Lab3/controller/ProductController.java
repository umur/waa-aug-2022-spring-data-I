package com.miu.Lab3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miu.Lab3.entity.Product;
import com.miu.Lab3.service.ProductService;


@RestController("/Product")
public class ProductController {

    @Autowired
    private ProductService ProductService;

    @GetMapping("/products")
    public List<Product> findAll() {
        return ProductService.findAll();
    }


}
