package edu.miu.lab3.joincolumn_bidir.service;

import edu.miu.lab3.joincolumn_bidir.dto.ReviewDto;
import edu.miu.lab3.joincolumn_bidir.entity.Review;

import java.util.List;

public interface ReviewService {
    Review save(ReviewDto reviewDto);

    void delete(int id);

    Review getById(int id);

    List<Review> getAll();

    Review updateReview(Review review);

    List<ReviewDto> findAllReviewsByProductId(int id);
}
