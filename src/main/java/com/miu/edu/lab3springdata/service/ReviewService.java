package com.miu.edu.lab3springdata.service;

import com.miu.edu.lab3springdata.dto.ReviewDto;
import com.miu.edu.lab3springdata.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    List<ReviewDto> findAllByProductId(int id);
}
