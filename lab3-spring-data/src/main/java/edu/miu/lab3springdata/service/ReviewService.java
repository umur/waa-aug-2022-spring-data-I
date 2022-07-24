package edu.miu.lab3springdata.service;

import edu.miu.lab3springdata.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    public void save(ReviewDto reviewDto);
    public List<ReviewDto> findAll();
    public List<ReviewDto> findAllByProductId(int productId);
    public ReviewDto findById(int id);
    public void update(ReviewDto reviewDto);
    public void delete(int id);
}
