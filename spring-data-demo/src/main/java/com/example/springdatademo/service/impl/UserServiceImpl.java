package com.example.springdatademo.service.impl;

import com.example.springdatademo.dto.UserDto;
import com.example.springdatademo.dto.UserDto;
import com.example.springdatademo.entity.User;
import com.example.springdatademo.repository.UserRepository;
import com.example.springdatademo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(user -> userToDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto save(UserDto userDto) {
        return userToDto(userRepository.save(dtoToUser(userDto)));
    }

    @Override
    public UserDto findById(int userId) {
        return userToDto(userRepository.findById(userId).orElse(null));
    }

    @Override
    public UserDto update(UserDto userDto) {
        return userToDto(userRepository.save(dtoToUser(userDto)));
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    private UserDto userToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    private User dtoToUser(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
}
