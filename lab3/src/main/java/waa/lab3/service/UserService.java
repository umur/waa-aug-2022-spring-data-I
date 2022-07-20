package waa.lab3.service;

import waa.lab3.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findById(int id);

    void deleteById(int id);

    void saveUser(UserDto user);
}
