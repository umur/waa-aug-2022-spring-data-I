package com.lab3.waaaug2022springdatai.joincolumn_unidir.service;

import com.lab3.waaaug2022springdatai.joincolumn_unidir.dto.ReviewDto;
import com.lab3.waaaug2022springdatai.joincolumn_unidir.entity.Review;

import java.util.List;

public interface ReviewService {
    Review save(ReviewDto reviewDto);

    void delete(int id);

    Review getById(int id);

    List<Review> getAll();

    Review updateReview(Review review);

    List<ReviewDto> findAllReviewsByProductId(int id);
}
