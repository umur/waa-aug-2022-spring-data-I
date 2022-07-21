package lab3.repository;


import lab3.entity.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepo extends CrudRepository<Review, Integer> {
    List<Review> findAllByProduct_Id(int id);
}
