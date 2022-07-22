package edu.miu.waa575.lab3springdata.controller;

import edu.miu.waa575.lab3springdata.dto.ProductDto;
import edu.miu.waa575.lab3springdata.dto.ReviewDto;
import edu.miu.waa575.lab3springdata.entity.Product;
import edu.miu.waa575.lab3springdata.entity.Review;
import edu.miu.waa575.lab3springdata.service.ProductService;
import edu.miu.waa575.lab3springdata.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {


    private  final ReviewService reviewService;

    @GetMapping
    public List<ReviewDto> findAll(){
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public  ReviewDto findById(@PathVariable int id){
        return reviewService.findById(id);
    }

    @PostMapping
    public ReviewDto save(@RequestBody ReviewDto reviewDto){
        return reviewService.save(reviewDto);
    }

    @PutMapping
    public Review update(@RequestBody Review review){
        return reviewService.update(review);
    }

    @DeleteMapping("/{id}")
    public  void remove(@PathVariable int id){
        reviewService.remove(id);
    }
}