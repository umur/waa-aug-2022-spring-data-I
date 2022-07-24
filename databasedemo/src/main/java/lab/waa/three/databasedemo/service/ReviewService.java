package lab.waa.three.databasedemo.service;

import lab.waa.three.databasedemo.dto.ProductDto;
import lab.waa.three.databasedemo.dto.ReviewDto;
import lab.waa.three.databasedemo.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
  void save(ReviewDto dto);

  void delete(int id);

  void update(int id, ReviewDto dto);

  List<ReviewDto> findAll();

  ReviewDto findById(int id);
}
