package miu.edu.lab3.service;

import miu.edu.lab3.dto.*;
import miu.edu.lab3.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAll();
    ProductDetailsDto getById(int id);
    void save(ProductCreateDto pro);
    void delete(int id);
    List<ProductDto> findByMinPrice(float price);
    List<ProductDto> findByMaxPriceAndCatName(float price, String name);
    void update(int id, ProductCreateDto productCreateDto) throws Exception;
}
