package com.miu.Lab3.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miu.Lab3.entity.Review;
import com.miu.Lab3.service.ReviewService;
import com.miu.Lab3.repository.ReviewRepository;



/**
 * @author laithnassar
 *
 */
@Service
public class ReviewServiceImpl implements ReviewService {
    
    
    @Autowired
    private ReviewRepository ReviewRepository;

    @Override
    public List<Review> findAll() {
        var result = new ArrayList<Review>();
        ReviewRepository.findAll().forEach(s -> result.add(s));
        return result;
        
    }    
    
    

}
