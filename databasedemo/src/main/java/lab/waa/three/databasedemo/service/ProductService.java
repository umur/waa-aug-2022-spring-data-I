package lab.waa.three.databasedemo.service;

import lab.waa.three.databasedemo.dto.ProductDto;
import lab.waa.three.databasedemo.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
  void save(ProductDto dto);

  void delete(int id);

  void update(int id, ProductDto dto);

  List<ProductDto> findAll();

  ProductDto findById(int id);
}
