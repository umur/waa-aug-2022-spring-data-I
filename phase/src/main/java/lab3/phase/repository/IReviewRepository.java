package lab3.phase.repository;

import lab3.phase.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReviewRepository extends CrudRepository<Review, Integer> {
}
