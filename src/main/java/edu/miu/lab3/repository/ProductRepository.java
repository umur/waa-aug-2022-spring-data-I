package edu.miu.lab3.repository;

import edu.miu.lab3.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByPriceGreaterThan(Double minPrice);
    List<Product> findByPriceLessThan(Double maxPrice);
    List<Product> findByNameContains(String key);
    Product findProductById(Integer id);

}
