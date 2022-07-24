package lab.waa.three.databasedemo.mapper;

import lab.waa.three.databasedemo.dto.ProductDto;
import lab.waa.three.databasedemo.dto.UserDto;
import lab.waa.three.databasedemo.entity.Product;
import lab.waa.three.databasedemo.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductMapper {
  private final ModelMapper modelMapper;

  public ProductDto toDTO(Product product) {
    return modelMapper.map(product, ProductDto.class);
  }

  public Product toModel(ProductDto dto) {
    return modelMapper.map(dto, Product.class);
  }
}
