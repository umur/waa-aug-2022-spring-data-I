package lab.waa.three.databasedemo.service.impl;

import lab.waa.three.databasedemo.dto.ProductDto;
import lab.waa.three.databasedemo.mapper.ProductMapper;
import lab.waa.three.databasedemo.reposoitory.ProductRepository;
import lab.waa.three.databasedemo.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
  private final ProductRepository repository;
  private final ProductMapper mapper;

  @Override
  public void save(ProductDto dto) {
    repository.save(mapper.toModel(dto));
  }

  @Override
  public void delete(int id) {
    repository.deleteById(id);
  }

  @Override
  public void update(int id, ProductDto dto) {
    repository.save(mapper.toModel(dto));
  }

  @Override
  public List<ProductDto> findAll() {
    var result = new ArrayList<ProductDto>();
    var data = repository.findAll();

    data.forEach(d -> result.add(mapper.toDTO(d)));

    return result;
  }

  @Override
  public ProductDto findById(int id) {
    return mapper.toDTO(repository.findById(id).orElse(null));
  }

  @Override
  public List<ProductDto> findProductByPriceGreaterThan(double minPrice) {
    var result = new ArrayList<ProductDto>();
    var data = repository.findAllByPriceGreaterThan(minPrice);

    data.forEach(d -> result.add(mapper.toDTO(d)));

    return result;  }

  @Override
  public List<ProductDto> findProductByCategoryIdAndPriceLessThan(String categoryName, double maxPrice) {
    var result = new ArrayList<ProductDto>();
    var data = repository.findAllByCategoryNameAndPriceLessThan(categoryName, maxPrice);

    data.forEach(d -> result.add(mapper.toDTO(d)));

    return result;
  }

  @Override
  public List<ProductDto> findProductByCategoryNameContains(String keyword) {
    var result = new ArrayList<ProductDto>();
    var data = repository.findProductByCategoryNameContains(keyword);

    data.forEach(d -> result.add(mapper.toDTO(d)));

    return result;
  }
}
