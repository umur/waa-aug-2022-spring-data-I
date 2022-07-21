package edu.miu.lab3.repository;

import edu.miu.lab3.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends CrudRepository<Product,Integer> {
}
