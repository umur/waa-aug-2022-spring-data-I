package lab.waa.three.databasedemo.mapper;

import lab.waa.three.databasedemo.dto.CategoryDto;
import lab.waa.three.databasedemo.dto.ProductDto;
import lab.waa.three.databasedemo.dto.UserDto;
import lab.waa.three.databasedemo.entity.Category;
import lab.waa.three.databasedemo.entity.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryMapper {
  private final ModelMapper modelMapper;

  public CategoryDto toDTO(Category model) {
    return modelMapper.map(model, CategoryDto.class);
  }

  public Category toModel(CategoryDto dto) {
    return modelMapper.map(dto, Category.class);
  }
}
