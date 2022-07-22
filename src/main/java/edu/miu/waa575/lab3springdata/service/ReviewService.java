package edu.miu.waa575.lab3springdata.service;

import edu.miu.waa575.lab3springdata.dto.ReviewDto;
import edu.miu.waa575.lab3springdata.dto.UserDto;
import edu.miu.waa575.lab3springdata.entity.Review;
import edu.miu.waa575.lab3springdata.entity.User;

import java.util.List;

public interface ReviewService {
    List<ReviewDto> findAll();
    ReviewDto findById(int reviewId);
    ReviewDto save(ReviewDto reviewDto);
    Review update(Review review);
    void remove(int reviewId);

//    List<ReviewDto> findAllByProductId(int productId);
}
