package waa.lab3.service.impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import waa.lab3.dto.ReviewDto;
import waa.lab3.dto.UserDto;
import waa.lab3.entity.User;
import waa.lab3.repository.UserRepo;
import waa.lab3.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private final ModelMapper modelMapper;

    @Override
    public List<UserDto> findAll() {
        var result = new ArrayList<UserDto>();
        userRepo.findAll().forEach(user -> result.add(modelMapper.map(user, UserDto.class)));
        return result;
    }

    @Override
    public UserDto findById(int id) {
        return modelMapper.map(userRepo.findById(id).get(), UserDto.class);
    }

    @Override
    public void deleteById(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public void saveUser(UserDto userDto) {
        userRepo.save(modelMapper.map(userDto, User.class));
    }
}
