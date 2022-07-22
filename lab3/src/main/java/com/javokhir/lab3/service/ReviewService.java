package com.javokhir.lab3.service;

import com.javokhir.lab3.dto.ReviewDto;

import java.util.List;

public interface ReviewService extends CrudService<ReviewDto, Long> {

    List<ReviewDto> getAllByProductId(Long productId);
}
