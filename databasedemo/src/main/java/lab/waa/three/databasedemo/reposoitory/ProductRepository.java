package lab.waa.three.databasedemo.reposoitory;

import lab.waa.three.databasedemo.entity.Product;
import lab.waa.three.databasedemo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
  List<Product> findAllByPriceGreaterThan(double minPrice);
  List<Product> findAllByCategoryNameAndPriceLessThan(String categoryName, double maxPrice);
  List<Product> findProductByCategoryNameContains(String keyword);
}
