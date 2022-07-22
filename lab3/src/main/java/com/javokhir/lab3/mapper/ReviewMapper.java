package com.javokhir.lab3.mapper;

import com.javokhir.lab3.domain.Review;
import com.javokhir.lab3.dto.ReviewDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {UserMapper.class, ProductMapper.class})
public interface ReviewMapper {

    Review fromDto(ReviewDto dto);

    @Mapping(target = "user", qualifiedByName = "excludeRelationsUser")
    @Mapping(target = "product", qualifiedByName = "excludeRelationsProduct")
    ReviewDto toDto(Review review);

    @Named("excludeRelationsReview")
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "product", ignore = true)
    ReviewDto excludeRelationsReview(Review review);
}
