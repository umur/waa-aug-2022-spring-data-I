package bekmax.springdata1.service;

import bekmax.springdata1.dto.ProductDto;
import bekmax.springdata1.dto.UserDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();

    ProductDto save(ProductDto productDto);

    ProductDto get(Long productId);

    void delete(Long productId);

    List<ProductDto> filterByGreaterThanMinPrice(Double minPrice);

    List<ProductDto> filterByCategoryAndLessThanMaxPrice(Long categoryId, Double maxPrice);

    List<ProductDto> filterByKeyword(String keyword);

}
