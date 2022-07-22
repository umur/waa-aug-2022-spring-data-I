package com.javokhir.lab3.mapper;

import com.javokhir.lab3.domain.Category;
import com.javokhir.lab3.dto.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface CategoryMapper {

    Category fromDto(CategoryDto dto);

    @Mapping(target = "products", qualifiedByName = "excludeRelationsProduct")
    CategoryDto toDto(Category category);

    @Named("excludeProduct")
    @Mapping(target = "products", ignore = true)
    CategoryDto excludeProduct(Category category);
}
