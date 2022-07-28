package com.miu.edu.lab3springdata.service.imp;

import com.miu.edu.lab3springdata.dto.ReviewDto;
import com.miu.edu.lab3springdata.entity.Product;
import com.miu.edu.lab3springdata.entity.Review;
import com.miu.edu.lab3springdata.repository.ReviewRepository;
import com.miu.edu.lab3springdata.service.ReviewService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
@AllArgsConstructor
public class ReviewServiceImp implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;

    public List<ReviewDto> findAllByProductId(int id) {
        List<Review> reviews = new ArrayList<>();
        reviews.addAll(reviewRepository.findAllByProductId(id));
        return reviews.stream()
                .map(review -> modelMapper.map(review, ReviewDto.class))
                .collect(Collectors.toList());
    }
}
