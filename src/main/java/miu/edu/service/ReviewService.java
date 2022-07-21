package miu.edu.service;

import miu.edu.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    List<ReviewDto> findAll();

    ReviewDto save(ReviewDto reviewDto);

    ReviewDto getOne(int reviewId);

    void remove(int reviewId);

    List<ReviewDto> findAllByProductId(int productId);
}
