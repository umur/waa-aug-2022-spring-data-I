package edu.miu.lab3.repository;

import edu.miu.lab3.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends CrudRepository<Product,Integer> {

    List<Product> findAllByPriceGreaterThan(double price);
    List<Product> findAllByCategory_Name_AndPriceLessThan(String category, double price);
    List<Product> findAllByNameContainingIgnoreCase(String keyword);
}
