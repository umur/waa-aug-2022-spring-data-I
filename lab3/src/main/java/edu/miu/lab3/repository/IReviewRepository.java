package edu.miu.lab3.repository;

import edu.miu.lab3.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReviewRepository extends CrudRepository<Review,Integer> {
}
