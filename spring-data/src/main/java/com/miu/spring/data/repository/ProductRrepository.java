package com.miu.spring.data.repository;

import com.miu.spring.data.entity.Category;
import com.miu.spring.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRrepository extends JpaRepository<Product, Integer> {
    List<Product> findProductByPriceGreaterThan(double minPrice);
    List<Product> findProductsByNameContains(String keyword);

    Optional<List<Product>>  findProductsByCategoryAndPriceLessThan(Category categoryId, double maxValue);
}
