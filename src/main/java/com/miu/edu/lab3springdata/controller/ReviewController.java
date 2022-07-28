package com.miu.edu.lab3springdata.controller;

import com.miu.edu.lab3springdata.dto.ReviewDto;
import com.miu.edu.lab3springdata.entity.Review;
import com.miu.edu.lab3springdata.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("review")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/{id}")
    @ResponseBody
    public List<ReviewDto> getAllByProductId(@PathVariable int id) {
        return reviewService.findAllByProductId(id);
    }
}
