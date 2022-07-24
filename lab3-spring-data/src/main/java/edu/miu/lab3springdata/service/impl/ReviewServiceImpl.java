package edu.miu.lab3springdata.service.impl;

import edu.miu.lab3springdata.dto.ReviewDto;
import edu.miu.lab3springdata.entity.Review;
import edu.miu.lab3springdata.repository.ReviewRepo;
import edu.miu.lab3springdata.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(ReviewDto reviewDto) {
        reviewRepo.save(modelMapper.map(reviewDto, Review.class));
    }

    @Override
    public List<ReviewDto> findAll() {
        var reviews = new ArrayList<ReviewDto>();
        reviewRepo.findAll().forEach(r -> reviews.add(modelMapper.map(r, ReviewDto.class)));
        return reviews;
    }

    @Override
    public List<ReviewDto> findAllByProductId(int productId) {
        var reviews = reviewRepo.findAllByProductId(productId);
        return reviews.stream().map(r -> modelMapper.map(r, ReviewDto.class)).collect(Collectors.toList());
    }

    @Override
    public ReviewDto findById(int id) {
        var review = reviewRepo.findById(id).orElse(null);
        return review != null ? modelMapper.map(review, ReviewDto.class) : null;
    }

    @Override
    public void update(ReviewDto reviewDto) {
        if(reviewRepo.existsById(reviewDto.getId()))
            save(reviewDto);
    }

    @Override
    public void delete(int id) {
        var review = reviewRepo.findById(id).orElse(null);
        if(review != null)
            reviewRepo.delete(review);
    }
}
