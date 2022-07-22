package bekmax.springdata1.service.impl;

import bekmax.springdata1.dto.ReviewDto;
import bekmax.springdata1.model.Product;
import bekmax.springdata1.model.Review;
import bekmax.springdata1.model.User;
import bekmax.springdata1.repository.ProductRepository;
import bekmax.springdata1.repository.ReviewRepository;
import bekmax.springdata1.repository.UserRepository;
import bekmax.springdata1.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    public List<ReviewDto> findAll() {
        return reviewRepository.findAll().stream().map(this::convertReviewToDto).toList();
    }

    @Override
    public ReviewDto save(ReviewDto reviewDto) {
        Review review = reviewRepository.save(convertDtoToReview(reviewDto));
        reviewDto.setId(review.getId());
        return reviewDto;
    }

    @Override
    public ReviewDto get(Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        return review.map(this::convertReviewToDto).orElse(null);
    }

    @Override
    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public List<ReviewDto> findReviewsByProductId(Long productId) {
        return findAll()
                .stream()
                .filter(r->r.getProductId().equals(productId))
                .toList();
    }

    private ReviewDto convertReviewToDto(Review review) {
        return new ReviewDto(review.getId(),
                review.getComment(),
                review.getUser().getId(),
                review.getProduct().getId());
    }

    private Review convertDtoToReview(ReviewDto reviewDto) {
        Optional<User> user = userRepository.findById(reviewDto.getUserId());
        Optional<Product> product = productRepository.findById(reviewDto.getProductId());

        if (user.isPresent() && product.isPresent()) {
            return new Review(reviewDto.getId(),
                    reviewDto.getComment(),
                    user.get(),
                    product.get());
        } else {
            throw new RuntimeException("Review user or product does not exist");
        }
    }
}
