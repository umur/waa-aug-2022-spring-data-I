package edu.miu.lab3.joincolumn_unidir.repository;

import edu.miu.lab3.joincolumn_unidir.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByPriceGreaterThan(double minCost);
    List<Product> findAllByPriceLessThanAndCategoryId(double price, int cat);
    List<Product> findByCategoryContaining(String keyword);
}
