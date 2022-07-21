package miu.edu.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.dto.ReviewDto;
import miu.edu.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewDto> findAll() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public ReviewDto getOne(@PathVariable Integer id) {
        return reviewService.getOne(id);
    }

    @PostMapping
    public ReviewDto save(@RequestBody ReviewDto reviewDto) {
        return reviewService.save(reviewDto);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Integer id) {
        reviewService.remove(id);
    }

    @GetMapping("/filter-by-product/{id}")
    public List<ReviewDto> getReviewsByProductId(@PathVariable Integer id) {
        return reviewService.findAllByProductId(id);
    }
}
