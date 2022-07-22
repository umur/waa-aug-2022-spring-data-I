package lab3.phase.repository;

import lab3.phase.entity.Category;
import lab3.phase.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findProductByPriceGreaterThan(float price);

    List<Product> findProductByCategoryAndPriceLessThan(Category cat, float price);

    List<Product> findProductByNameContaining(String name);
}
