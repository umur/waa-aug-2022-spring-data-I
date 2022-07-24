package com.miu.spring.data.service.impl;

import com.miu.spring.data.entity.Category;
import com.miu.spring.data.entity.Product;
import com.miu.spring.data.repository.CategoryRepository;
import com.miu.spring.data.repository.ProductRrepository;
import com.miu.spring.data.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRrepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    @Override
    public Optional<Product> getProductById(int id){
        return productRepository.findById(id);
    }
    @Override
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    @Override
    public void delete(int id){
        productRepository.deleteById(id);
    }
    public List<Product> findProductByPriceGreaterThan(double minPrice){
        return productRepository.findProductByPriceGreaterThan(minPrice);
    }

    public List<Product> findProductsByNameContains(String keyword){
        return productRepository.findProductsByNameContains(keyword);
    }
    @Override
    public List<Product> findProductsByCategoryAndPriceLessThan(Category categoryId, double maxValue){
        return productRepository.findProductsByCategoryAndPriceLessThan(categoryId, maxValue).orElseGet(ArrayList::new);
    }
    public List<Product> findProductsByPriceGreaterThan(double price){
        return productRepository.findProductByPriceGreaterThan(price);
    }

}
