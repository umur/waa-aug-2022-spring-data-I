package lab.waa.three.databasedemo.service;

import lab.waa.three.databasedemo.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
  void save(UserDto courseDto);

  void delete(int id);

  void update(int id, UserDto userDto);

  List<UserDto> findAll();

  UserDto findById(int id);
}
