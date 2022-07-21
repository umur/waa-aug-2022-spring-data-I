package lab3.phase.repository;

import lab3.phase.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends CrudRepository<Product, Integer> {
}
