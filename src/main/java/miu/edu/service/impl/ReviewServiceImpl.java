package miu.edu.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.dto.ReviewDto;
import miu.edu.entity.Product;
import miu.edu.entity.Review;
import miu.edu.entity.User;
import miu.edu.repository.ProductRepository;
import miu.edu.repository.ReviewRepository;
import miu.edu.repository.UserRepository;
import miu.edu.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    private final ProductRepository productRepository;

    @Override
    public List<ReviewDto> findAll() {
        return reviewRepository.findAll().stream().map(this::reviewToDto).collect(Collectors.toList());
    }

    @Override
    public ReviewDto save(ReviewDto reviewDto) {
        reviewRepository.save(dtoToReview(reviewDto));
        return reviewDto;
    }

    @Override
    public ReviewDto getOne(int reviewId) {
        return reviewRepository.findById(reviewId).map(this::reviewToDto).orElse(null);
    }

    @Override
    public void remove(int reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    @Override
    public List<ReviewDto> findAllByProductId(int productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (!product.isPresent())
            return Collections.emptyList();
        return reviewRepository.findAllByProduct(product.get()).stream().map(this::reviewToDto).collect(Collectors.toList());
    }

    private ReviewDto reviewToDto(Review review) {
        return new ReviewDto(review.getId(), review.getComment(), review.getUser().getId(), review.getProduct().getId());
    }

    private Review dtoToReview(ReviewDto reviewDto) {
        Optional<User> user = userRepository.findById(reviewDto.getUserId());
        if (!user.isPresent())
            throw new RuntimeException("User not found");
        Optional<Product> product = productRepository.findById(reviewDto.getProductId());
        if (!product.isPresent())
            throw new RuntimeException("Product not found");
        return new Review(reviewDto.getId(), reviewDto.getComment(), user.get(), product.get());
    }
}
