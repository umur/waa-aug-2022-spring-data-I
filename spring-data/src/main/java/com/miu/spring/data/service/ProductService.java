package com.miu.spring.data.service;

import com.miu.spring.data.entity.Category;
import com.miu.spring.data.entity.Product;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    public List<Product> getAllProduct();
    public Optional<Product> getProductById(int id);
    public void delete(int id);
    public Product saveProduct(Product product);

    List<Product> findProductsByPriceGreaterThan(double price);
    List<Product> findProductsByCategoryAndPriceLessThan(Category category, double price);

}
