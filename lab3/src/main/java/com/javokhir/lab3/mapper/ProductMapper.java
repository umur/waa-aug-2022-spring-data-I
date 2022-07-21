package com.javokhir.lab3.mapper;

import com.javokhir.lab3.domain.Product;
import com.javokhir.lab3.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    Product fromDto(ProductDto dto);

    @Mapping(target = "category", qualifiedByName = "excludeProduct")
    ProductDto toDto(Product product);
}
