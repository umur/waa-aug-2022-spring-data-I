package bekmax.springdata1.controller;

import bekmax.springdata1.dto.ReviewDto;
import bekmax.springdata1.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewDto> findAll() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public ReviewDto get(@PathVariable Long id) {
        return reviewService.get(id);
    }

    @PostMapping
    public ReviewDto save(@RequestBody ReviewDto reviewDto) {
        return reviewService.save(reviewDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reviewService.delete(id);
    }

    @GetMapping("/product/{productId}")
    public List<ReviewDto> findReviewsByProductId(@PathVariable Long productId) {
        return reviewService.findReviewsByProductId(productId);
    }
}
