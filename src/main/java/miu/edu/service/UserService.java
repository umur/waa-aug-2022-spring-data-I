package miu.edu.service;

import miu.edu.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto save(UserDto userDto);

    UserDto getOne(int userId);

    void remove(int userId);
}
