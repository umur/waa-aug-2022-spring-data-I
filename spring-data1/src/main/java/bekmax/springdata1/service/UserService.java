package bekmax.springdata1.service;

import bekmax.springdata1.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto save(UserDto userDto);

    UserDto get(Long userId);

    void delete(Long userId);
}
