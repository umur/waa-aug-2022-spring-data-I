package edu.miu.lab3springdata.repository;

import edu.miu.lab3springdata.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends CrudRepository<Review, Integer> {
}
