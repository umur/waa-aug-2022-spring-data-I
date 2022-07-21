package cs545waa.lab3.repository;

import cs545waa.lab3.entity.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepo extends CrudRepository<Review, Integer> {
}
