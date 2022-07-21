package com.javokhir.lab3.mapper;

import com.javokhir.lab3.domain.Review;
import com.javokhir.lab3.dto.ReviewDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    Review fromDto(ReviewDto dto);

    ReviewDto toDto(Review review);
}
