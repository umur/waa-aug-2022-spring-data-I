package edu.miu.lab3springdata.repository;

import edu.miu.lab3springdata.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
    public List<Product> findAllByPriceGreaterThan(float minPrice);
}
