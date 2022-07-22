package bekmax.springdata1.repository;

import bekmax.springdata1.model.Category;
import bekmax.springdata1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
