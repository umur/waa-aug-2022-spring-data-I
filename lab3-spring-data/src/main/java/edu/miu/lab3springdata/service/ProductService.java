package edu.miu.lab3springdata.service;

import edu.miu.lab3springdata.dto.ProductDto;

import java.util.List;

public interface ProductService {
    public void save(ProductDto productDto);
    public List<ProductDto> findAll();
    public ProductDto findById(int id);
    public List<ProductDto> findAllByPriceGreaterThan(float minPrice);
    public void update(ProductDto productDto);
    public void delete(int id);
}
