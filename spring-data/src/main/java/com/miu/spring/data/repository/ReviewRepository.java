package com.miu.spring.data.repository;

import com.miu.spring.data.entity.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
    public List<Review> findReviewById(int id);
}
