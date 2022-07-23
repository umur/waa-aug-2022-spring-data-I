package miu.edu.lab03.service;

import miu.edu.lab03.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> getAll();
    Optional<Review> getById(Long id);
    Review save(Review review);
    void delete(Long id);

    List<Review> findByProduct(Long id);
}
