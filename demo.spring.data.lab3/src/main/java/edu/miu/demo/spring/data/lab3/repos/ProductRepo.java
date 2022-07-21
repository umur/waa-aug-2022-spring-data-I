package edu.miu.demo.spring.data.lab3.repos;

import edu.miu.demo.spring.data.lab3.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
}
