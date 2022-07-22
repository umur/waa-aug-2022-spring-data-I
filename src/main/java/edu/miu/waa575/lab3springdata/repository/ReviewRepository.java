package edu.miu.waa575.lab3springdata.repository;

import edu.miu.waa575.lab3springdata.entity.Product;
import edu.miu.waa575.lab3springdata.entity.Review;
import edu.miu.waa575.lab3springdata.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
//    List<Review> findAllByProductId
//    List<Review> findAllByProduct(Product product);
}
