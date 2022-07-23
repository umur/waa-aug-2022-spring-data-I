package lab.waa.three.databasedemo.mapper;

import lab.waa.three.databasedemo.dto.UserDto;
import lab.waa.three.databasedemo.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMapper {
  private final ModelMapper modelMapper;

  public UserDto toDTO(User user) {
    return modelMapper.map(user, UserDto.class);
  }

  public User toModel(UserDto dto) {
    return modelMapper.map(dto, User.class);
  }
}
