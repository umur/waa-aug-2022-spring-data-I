package com.miu.Lab3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miu.Lab3.entity.Review;


/**
 * @author laithnassar
 *
 */
@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {


}