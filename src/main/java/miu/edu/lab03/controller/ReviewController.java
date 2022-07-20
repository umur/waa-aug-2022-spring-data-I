package miu.edu.lab03.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.lab03.dto.ReviewDTO;
import miu.edu.lab03.model.Review;
import miu.edu.lab03.service.ReviewServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewServiceImpl service;

    private final ModelMapper mapper;

    @GetMapping
    public List<ReviewDTO> getAll() {
        return service.getAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(this::toDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ReviewDTO save(@RequestBody Review review) {
        return this.toDTO(service.save(review));
    }

    @PutMapping("/{id}")
    public ReviewDTO update(@PathVariable Long id, @RequestBody Review review) {
        review.setId(id);
        return this.toDTO(service.save(review));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("filter-by-product/{id}")
    public List<ReviewDTO> getByProduct(@PathVariable Long id) {
        return service.findByProduct(id)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private ReviewDTO toDTO(Review review) {
        return mapper.map(review, ReviewDTO.class);
    }

    private Review toEntity(ReviewDTO review) {
        return mapper.map(review, Review.class);
    }
}
