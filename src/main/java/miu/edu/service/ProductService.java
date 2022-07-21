package miu.edu.service;

import miu.edu.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();

    ProductDto save(ProductDto productDto);

    ProductDto getOne(int productId);

    void remove(int productId);

    List<ProductDto> filterByMinPrice(Double price);

    List<ProductDto> filterByCatAndMaxPrice(int catId, Double price);

    List<ProductDto> filterByKeyword(String keyword);
}
