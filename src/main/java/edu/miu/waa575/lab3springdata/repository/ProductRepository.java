package edu.miu.waa575.lab3springdata.repository;

import edu.miu.waa575.lab3springdata.entity.Product;
import edu.miu.waa575.lab3springdata.entity.User;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
     List<Product> findAllByPriceGreaterThan(Double minPrice) ;

     List<Product> findAllByCategoryAndPriceLessThan(Category cat, Double maxPrice);

     List<Product> findAllByNameContaining(String keyword);

}
