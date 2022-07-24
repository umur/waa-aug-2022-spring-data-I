package edu.miu.lab3springdata.controller;

import edu.miu.lab3springdata.dto.ReviewDto;
import edu.miu.lab3springdata.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public void save(@RequestBody ReviewDto reviewDto) {
        reviewService.save(reviewDto);
    }

    @GetMapping
    public List<ReviewDto> findAll() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public ReviewDto findById(@PathVariable int id) {
        return reviewService.findById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody ReviewDto reviewDto) {
        reviewDto.setId(id);
        reviewService.update(reviewDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        reviewService.delete(id);
    }

}
