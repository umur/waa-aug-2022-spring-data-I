package lab.waa.three.databasedemo.service.impl;

import lab.waa.three.databasedemo.dto.ReviewDto;
import lab.waa.three.databasedemo.mapper.ReviewMapper;
import lab.waa.three.databasedemo.reposoitory.ReviewRepository;
import lab.waa.three.databasedemo.service.ReviewService;
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

  @Override
  public void save(ReviewDto dto) {
    repository.save(mapper.toModel(dto));
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
}
