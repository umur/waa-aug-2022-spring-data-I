package miu.edu.lab3.service;

import miu.edu.lab3.dto.UserCreateDto;
import miu.edu.lab3.dto.UserDetailsDto;
import miu.edu.lab3.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();
    UserDetailsDto getById(int id);
    void save(UserCreateDto user);
    void delete(int id);
    void update(int id, UserCreateDto user) throws Exception;

}
