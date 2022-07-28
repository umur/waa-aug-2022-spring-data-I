package com.miu.edu.lab3springdata.service;

import com.miu.edu.lab3springdata.dto.ProductDto;
import com.miu.edu.lab3springdata.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<ProductDto> findByPriceMin(double price);
    List<ProductDto> findByCatNameWithMaxPrice(String cat, double price);
    List<ProductDto> findByName(String name);
}
