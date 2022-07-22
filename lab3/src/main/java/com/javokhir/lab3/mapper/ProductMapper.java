package com.javokhir.lab3.mapper;

import com.javokhir.lab3.domain.Product;
import com.javokhir.lab3.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, ReviewMapper.class})
public interface ProductMapper {

    Product fromDto(ProductDto dto);

    @Mapping(target = "category", qualifiedByName = "excludeProduct")
    @Mapping(target = "reviews", qualifiedByName = "excludeRelationsReview")
    ProductDto toDto(Product product);

    @Named("excludeRelationsProduct")
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    ProductDto excludeRelationsProduct(Product product);
}
