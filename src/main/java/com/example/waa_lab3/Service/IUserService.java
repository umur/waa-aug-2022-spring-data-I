package com.example.waa_lab3.Service;

import com.example.waa_lab3.DTO.UserDto;

import java.util.List;

public interface IUserService {

    List<UserDto> findAll();
    UserDto getUser(int id);
    UserDto updateUser(UserDto userDto, int id);
    UserDto addUser(UserDto userDto);
    void deleteUser(int id);
}
