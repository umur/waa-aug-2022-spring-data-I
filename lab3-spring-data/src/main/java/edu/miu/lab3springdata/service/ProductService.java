package edu.miu.lab3springdata.service;

import edu.miu.lab3springdata.dto.ProductDto;

import java.util.List;

public interface ProductService {
    public void save(ProductDto productDto);
    public List<ProductDto> findAll();
    public ProductDto findById(int id);
    public List<ProductDto> findAllByPriceGreaterThanEqual(float minPrice);
    public List<ProductDto> findAllByCategoryIdAndPriceLessThanEqual(int categoryId, float maxPrice);
    public List<ProductDto> findAllByNameIsLikeIgnoreCase(String keyword);
    public void update(ProductDto productDto);
    public void delete(int id);
}
