package com.miu.Lab3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miu.Lab3.entity.Review;
import com.miu.Lab3.service.ReviewService;


@RestController("/Review")
public class ReviewController {

    @Autowired
    private ReviewService ReviewService;

    @GetMapping("/Reviews")
    public List<Review> findAll() {
        return ReviewService.findAll();
    }


}
