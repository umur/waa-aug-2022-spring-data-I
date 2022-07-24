package edu.miu.lab3springdata.repository;

import edu.miu.lab3springdata.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends CrudRepository<Review, Integer> {
    public List<Review> findAllByProductId(int productId);
}
