package cs545waa.lab3.service;

import cs545waa.lab3.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    List<ReviewDto> findAll();
    List<ReviewDto> findByProductId(Integer productId);
}
