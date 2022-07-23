package miu.edu.lab03.service;

import miu.edu.lab03.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();
    Optional<Product> getById(Long id);
    Product save(Product product);
    void delete(Long id);

    List<Product> findProductsByPriceGreaterThan(Double price);

    List<Product> findProductsByCategoryAndPriceLessThan(Long categoryId, Double price);

    List<Product> findProductsByNameContains(String word);
}
