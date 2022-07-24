package edu.miu.lab3springdata.service;

import edu.miu.lab3springdata.dto.UserDto;

import java.util.List;

public interface UserService {

    public void save(UserDto userDto);
    public List<UserDto> findAll();
    public UserDto findById(int id);
    public void update(UserDto userDto);
    public void delete(int id);
}
