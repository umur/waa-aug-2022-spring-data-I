package com.javokhir.lab3.service;

import com.javokhir.lab3.dto.ProductDto;

import java.util.List;

public interface ProductService extends CrudService<ProductDto, Long> {

    List<ProductDto> getByMinPrice(Double minPrice);

    List<ProductDto> getByCategoryAndMaxPrice(Long categoryId, double maxPrice);

    List<ProductDto> getByName(String name);
}
