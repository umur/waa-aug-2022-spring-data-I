package com.miu.edu.lab3springdata.repository;

import com.miu.edu.lab3springdata.entity.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
    List<Review> findAllByProductId(int id);
}
