package lab.waa.three.databasedemo.service;

import lab.waa.three.databasedemo.dto.CategoryDto;
import lab.waa.three.databasedemo.dto.ReviewDto;
import lab.waa.three.databasedemo.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
  void save(CategoryDto dto);

  void delete(int id);

  void update(int id, CategoryDto dto);

  List<CategoryDto> findAll();

  CategoryDto findById(int id);
}
