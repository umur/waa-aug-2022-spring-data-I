package com.miu.Lab3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.miu.Lab3.entity.Review;


/**
 * @author laithnassar
 *
 */

public interface ReviewService {
    
    List<Review> findAll();
    

}
