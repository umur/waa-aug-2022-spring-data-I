package com.javokhir.lab3.repository;

import com.javokhir.lab3.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductsByNameContainingIgnoreCase(String name);
    @Query("SELECT p FROM Product p where p.price > :minPrice")
    List<Product> findAllByMinPrice(@Param("minPrice") Double minPrice);

    @Query("select p from Product p where p.category.id = :categoryId and p.price < :maxPrice")
    List<Product> findAllByCategoryIdAndMaxPrice(Long categoryId, double maxPrice);
}
