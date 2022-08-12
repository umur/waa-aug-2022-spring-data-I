package com.example.waa_lab3.Service.Imp;

import com.example.waa_lab3.DTO.UserDto;
import com.example.waa_lab3.Domian.Category;
import com.example.waa_lab3.Domian.Product;
import com.example.waa_lab3.Domian.User;
import com.example.waa_lab3.Repository.UserRepository;
import com.example.waa_lab3.Service.IUserService;
import lombok.AllArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<UserDto> findAll() {
        var users = userRepository.findAll();
        var result = new ArrayList<UserDto>();

        for(User user: users){
            UserDto userDto = new UserDto();
            userDto = modelMapper.map(user, UserDto.class);
            result.add(userDto);
        }
        return result;
    }

    @Override
    public UserDto getUser(int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null){
            UserDto userDto = modelMapper.map(user, UserDto.class);
            return userDto;
        }
        return null;
    }

    @Override
    public UserDto updateUser(UserDto userDto, int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null){
            User user1 = modelMapper.map(userDto, User.class);
            User user2 = userRepository.save(user1);
            UserDto userDto1 = modelMapper.map(user2, UserDto.class);
            return  userDto1;
        }

        return null;
    }

    @Override
    public UserDto addUser(UserDto userDto) {

        User user = modelMapper.map(userDto, User.class);
        User user1 = userRepository.save(user);
        UserDto userDto1 = modelMapper.map(user1, UserDto.class);
        return userDto1;
    }

    @Override
    public void deleteUser(int id) {

        User user = userRepository.findById(id).orElse(null);
        if (user != null){
            userRepository.delete(user);
        }

    }
}
