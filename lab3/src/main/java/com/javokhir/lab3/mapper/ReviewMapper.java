package com.javokhir.lab3.mapper;

import com.javokhir.lab3.domain.Review;
import com.javokhir.lab3.dto.ReviewDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    Review fromDto(ReviewDto dto);

    ReviewDto toDto(Review review);

    @Named("excludeUser")
    @Mapping(target = "user", ignore = true)
    ReviewDto excludeUser(Review review);
}
