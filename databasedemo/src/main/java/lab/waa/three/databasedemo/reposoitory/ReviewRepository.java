package lab.waa.three.databasedemo.reposoitory;

import lab.waa.three.databasedemo.dto.ReviewDto;
import lab.waa.three.databasedemo.entity.Review;
import lab.waa.three.databasedemo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {

  List<Review> findReviewsByUserId(int productId);
}
