package edu.miu.waa575.lab3springdata.service.impl;

import edu.miu.waa575.lab3springdata.dto.ProductDto;
import edu.miu.waa575.lab3springdata.dto.ReviewDto;
import edu.miu.waa575.lab3springdata.entity.Product;
import edu.miu.waa575.lab3springdata.entity.Review;
import edu.miu.waa575.lab3springdata.repository.ProductRepository;
import edu.miu.waa575.lab3springdata.repository.ReviewRepository;
import edu.miu.waa575.lab3springdata.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private ModelMapper modelMapper;

    private final ProductRepository productRepository;

    @Override
    public List<ReviewDto> findAll() {
        return reviewRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ReviewDto findById(int reviewId) {
        return reviewRepository.findById(reviewId).map(this::toDto).orElse(null);
    }

    @Override
    public ReviewDto save(ReviewDto reviewDto) {
        reviewRepository.save(dtoToEntity(reviewDto));
        return reviewDto;
    }

    @Override
    public Review update(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public void remove(int reviewId) {
        reviewRepository.deleteById(reviewId);
    }


    //FILTER
//    @Override
//    public List<ReviewDto> findAllByProductId(int productId) {
//        Optional<Product> product = productRepository.findById(productId);
//        if (!product.isPresent())
//            return Collections.emptyList();
//        return reviewRepository.findAllByProduct(product.get()).stream().map(this::toDto).collect(Collectors.toList());
//    }


    //MappeR
    private ReviewDto toDto(Review review) {
        return modelMapper.map(review, ReviewDto.class);
    }

    private Review dtoToEntity(ReviewDto reviewDto) {
        return modelMapper.map(reviewDto, Review.class);
    }
}
