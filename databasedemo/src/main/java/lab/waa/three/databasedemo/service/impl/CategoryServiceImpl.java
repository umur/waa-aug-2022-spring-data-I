package lab.waa.three.databasedemo.service.impl;

import lab.waa.three.databasedemo.dto.CategoryDto;
import lab.waa.three.databasedemo.mapper.AddressMapper;
import lab.waa.three.databasedemo.mapper.CategoryMapper;
import lab.waa.three.databasedemo.reposoitory.AddressRepository;
import lab.waa.three.databasedemo.reposoitory.CategoryRepository;
import lab.waa.three.databasedemo.service.AddressService;
import lab.waa.three.databasedemo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
  private final CategoryRepository repository;
  private final CategoryMapper mapper;

  @Override
  public void save(CategoryDto dto) {
    repository.save(mapper.toModel(dto));
  }

  @Override
  public void delete(int id) {
    repository.deleteById(id);
  }

  @Override
  public void update(int id, CategoryDto dto) {
    repository.save(mapper.toModel(dto));
  }

  @Override
  public List<CategoryDto> findAll() {
    var result = new ArrayList<CategoryDto>();
    var data = repository.findAll();

    data.forEach(d -> result.add(mapper.toDTO(d)));

    return result;
  }

  @Override
  public CategoryDto findById(int id) {
    return mapper.toDTO(repository.findById(id).orElse(null));
  }
}
