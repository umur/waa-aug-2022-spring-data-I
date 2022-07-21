package edu.miu.demo.spring.data.lab3.services;

import edu.miu.demo.spring.data.lab3.dtos.ProductDto;

import java.util.List;

public interface ProductService {
    public List<ProductDto> getAll();
    public void save(ProductDto productDto);
    public void update(ProductDto productDto);
    public void delete(int id);
}
