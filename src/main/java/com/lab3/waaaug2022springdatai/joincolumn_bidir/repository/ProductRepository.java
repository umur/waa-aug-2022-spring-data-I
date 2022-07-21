package com.lab3.waaaug2022springdatai.joincolumn_bidir.repository;

import com.lab3.waaaug2022springdatai.joincolumn_bidir.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByPriceGreaterThan(double minCost);
    List<Product> findAllByPriceLessThanAndCategoryId(double price, int cat);
    List<Product> findByCategoryContaining(String keyword);
}
