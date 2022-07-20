package miu.edu.lab03.repository;

import miu.edu.lab03.model.Category;
import miu.edu.lab03.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductsByPriceGreaterThan(Double price);

    List<Product> findProductsByCategoryAndPriceLessThan(Category category, Double price);

    List<Product> findProductsByNameContains(String word);
}
