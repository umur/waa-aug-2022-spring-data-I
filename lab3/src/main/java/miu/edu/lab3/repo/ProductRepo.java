package miu.edu.lab3.repo;

import miu.edu.lab3.entity.Product;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
    List<Product> findAllByPriceGreaterThan(float price);
    List<Product> findAllByPriceLessThanAndCategoryName(float price, String name);
}
