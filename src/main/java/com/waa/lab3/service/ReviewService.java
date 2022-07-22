package com.waa.lab3.service;

import com.waa.lab3.dto.ReviewDTO;
import com.waa.lab3.entity.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<ReviewDTO> findAll();

    Optional<ReviewDTO> findById(Integer id);

    void save(ReviewDTO reviewDTO);

    void deleteById(Integer id);

    List<ReviewDTO> findAllByProduct(Integer productId);
}
