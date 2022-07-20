package miu.edu.lab03.repository;

import miu.edu.lab03.model.Product;
import miu.edu.lab03.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findReviewsByProduct(Product product);
}
