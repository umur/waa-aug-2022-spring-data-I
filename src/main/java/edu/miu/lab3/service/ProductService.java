package edu.miu.lab3.service;

import edu.miu.lab3.domain.Product;
import edu.miu.lab3.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();
    List<ProductDTO> findAllProductsPriceGreaterThan(Double price);
    List<ProductDTO> findAllProductsPriceLessThan(Double price);
    ProductDTO findById(int id);
    Product addProduct(ProductDTO productDto);
    Product updateProduct(Product product);
    void deleteById(int id);
}
