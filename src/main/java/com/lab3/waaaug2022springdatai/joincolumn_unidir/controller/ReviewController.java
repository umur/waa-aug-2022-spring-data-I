package com.lab3.waaaug2022springdatai.joincolumn_unidir.controller;

import com.lab3.waaaug2022springdatai.joincolumn_unidir.dto.ReviewDto;
import com.lab3.waaaug2022springdatai.joincolumn_unidir.entity.Review;
import com.lab3.waaaug2022springdatai.joincolumn_unidir.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController (ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public Review save(@RequestBody ReviewDto reviewDto) {
        return reviewService.save(reviewDto);
    }

    @GetMapping
    public List<Review> getAll() {
        return reviewService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getById(@PathVariable int id) {
        var review = reviewService.getById(id);
        return ResponseEntity.ok(review);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        reviewService.delete(id);
    }

    @PutMapping
    public Review update(@RequestBody Review review) {
        return reviewService.updateReview(review);
    }

    @GetMapping("/filter-by-product/{id}")
    public List<ReviewDto> findAllReviewsByProductId(@PathVariable(name = "id") int productId){
        return reviewService.findAllReviewsByProductId(productId);
    }
}
