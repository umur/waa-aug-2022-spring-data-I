package miu.edu.repository;

import miu.edu.entity.Category;
import miu.edu.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByPriceGreaterThan(Double price);

    List<Product> findAllByCategoryAndPriceLessThan(Category category, Double price);

    List<Product> findAllByNameContaining(String keyword);
}
