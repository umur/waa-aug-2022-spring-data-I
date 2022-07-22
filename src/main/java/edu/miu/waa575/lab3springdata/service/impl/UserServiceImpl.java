package edu.miu.waa575.lab3springdata.service.impl;

import edu.miu.waa575.lab3springdata.dto.ReviewDto;
import edu.miu.waa575.lab3springdata.dto.UserDto;
import edu.miu.waa575.lab3springdata.entity.Review;
import edu.miu.waa575.lab3springdata.entity.User;
import edu.miu.waa575.lab3springdata.repository.UserRepository;
import edu.miu.waa575.lab3springdata.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
    private ModelMapper modelMapper;


    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto findById(int userId) {
        return userRepository.findById(userId).map(this::toDto).orElse(null);
    }

    @Override
    public UserDto save(UserDto userDto) {
        userRepository.save(dtoToEntity(userDto));
        return userDto;
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void remove(int userId) {
       userRepository.deleteById(userId);
    }


    //MappeR
    private UserDto toDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    private User dtoToEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

}
