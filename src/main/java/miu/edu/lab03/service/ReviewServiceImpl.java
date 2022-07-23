package miu.edu.lab03.service;

import lombok.RequiredArgsConstructor;
import miu.edu.lab03.model.Review;
import miu.edu.lab03.repository.ProductRepository;
import miu.edu.lab03.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;

    private final ProductRepository productRepository;

    @Override
    public List<Review> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Review> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Review save(Review review) {
        return repository.save(review);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Review> findByProduct(Long id) {
        return productRepository.findById(id).map(repository::findReviewsByProduct)
                .orElseGet(ArrayList::new);
    }
}
