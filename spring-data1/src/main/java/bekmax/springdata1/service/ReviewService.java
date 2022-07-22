package bekmax.springdata1.service;

import bekmax.springdata1.dto.ReviewDto;
import bekmax.springdata1.model.Review;

import java.util.List;

public interface ReviewService {
    List<ReviewDto> findAll();

    ReviewDto save(ReviewDto reviewDto);

    ReviewDto get(Long id);

    void delete(Long reviewId);

    List<ReviewDto> findReviewsByProductId(Long productId);
}
