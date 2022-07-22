package edu.miu.waa575.lab3springdata.service;

import edu.miu.waa575.lab3springdata.dto.AddressDto;
import edu.miu.waa575.lab3springdata.dto.UserDto;
import edu.miu.waa575.lab3springdata.entity.User;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    UserDto findById(int userId);
    UserDto save(UserDto userDto);
    User update(User user);
    void remove(int userId);
}
