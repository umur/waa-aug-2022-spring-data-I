package lab.waa.three.databasedemo.mapper;

import lab.waa.three.databasedemo.dto.AddressDto;
import lab.waa.three.databasedemo.dto.ReviewDto;
import lab.waa.three.databasedemo.entity.Address;
import lab.waa.three.databasedemo.entity.Review;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewMapper {
  private final ModelMapper modelMapper;

  public ReviewDto toDTO(Review model) {
    return modelMapper.map(model, ReviewDto.class);
  }

  public Review toModel(ReviewDto dto) {
    return modelMapper.map(dto, Review.class);
  }
}
