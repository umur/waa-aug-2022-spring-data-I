package com.example.waa_lab3.Service;

import com.example.waa_lab3.DTO.ReviewDto;

import java.util.List;

public interface IReviewService {

    public interface ReviewService {
        List<ReviewDto> findAll();

        ReviewDto getReview(int id);

        ReviewDto addReview(ReviewDto reviewDto);

        ReviewDto updateReview(ReviewDto reviewDto, int id);

        void deleteReview(int id);
    }
}
