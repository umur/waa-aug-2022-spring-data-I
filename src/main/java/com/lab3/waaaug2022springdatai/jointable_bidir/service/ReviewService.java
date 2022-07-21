package com.lab3.waaaug2022springdatai.jointable_bidir.service;

import com.lab3.waaaug2022springdatai.jointable_bidir.dto.ReviewDto;
import com.lab3.waaaug2022springdatai.jointable_bidir.entity.Review;

import java.util.List;

public interface ReviewService {
    Review save(ReviewDto reviewDto);

    void delete(int id);

    Review getById(int id);

    List<Review> getAll();

    Review updateReview(Review review);

    List<ReviewDto> findAllReviewsByProductId(int id);
}
