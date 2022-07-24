package lab.waa.three.databasedemo.service.impl;

import lab.waa.three.databasedemo.dto.ReviewDto;
import lab.waa.three.databasedemo.entity.Review;
import lab.waa.three.databasedemo.entity.User;
import lab.waa.three.databasedemo.mapper.ReviewMapper;
import lab.waa.three.databasedemo.mapper.UserMapper;
import lab.waa.three.databasedemo.reposoitory.ReviewRepository;
import lab.waa.three.databasedemo.service.ReviewService;
import lab.waa.three.databasedemo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
  private final ReviewRepository repository;
  private final ReviewMapper mapper;
  private final UserMapper userMapper;
  private final UserService userService;

  @Override
  public void save(ReviewDto dto) {
    User user = userMapper.toModel(userService.findById(dto.getUserId()));
    Review review = mapper.toModel(dto);
    review.setUser(user);
    repository.save(review);
  }

  @Override
  public void delete(int id) {
    repository.deleteById(id);
  }

  @Override
  public void update(int id, ReviewDto dto) {
    repository.save(mapper.toModel(dto));
  }

  @Override
  public List<ReviewDto> findAll() {
    var result = new ArrayList<ReviewDto>();
    var data = repository.findAll();

    data.forEach(d -> result.add(mapper.toDTO(d)));

    return result;
  }

  @Override
  public ReviewDto findById(int id) {
    return mapper.toDTO(repository.findById(id).orElse(null));
  }

  @Override
  public List<ReviewDto> findReviewsByProductId(int productId) {
    var result = new ArrayList<ReviewDto>();
    var data = repository.findReviewsByUserId(productId);

    data.forEach(d -> result.add(mapper.toDTO(d)));

    return result;
  }
}
