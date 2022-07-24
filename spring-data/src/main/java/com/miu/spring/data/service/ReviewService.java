package com.miu.spring.data.service;

import com.miu.spring.data.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ReviewService {
    public List<Review> getAll();


}
