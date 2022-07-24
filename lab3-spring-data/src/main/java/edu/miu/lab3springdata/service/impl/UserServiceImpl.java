package edu.miu.lab3springdata.service.impl;

import edu.miu.lab3springdata.dto.UserDto;
import edu.miu.lab3springdata.entity.User;
import edu.miu.lab3springdata.repository.UserRepo;
import edu.miu.lab3springdata.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(UserDto userDto) {
        userRepo.save(modelMapper.map(userDto, User.class));
    }
    @Override
    public List<UserDto> findAll() {
        var users = new ArrayList<UserDto>();
        userRepo.findAll().forEach(u -> users.add(modelMapper.map(u, UserDto.class)));
        return users;
    }

    @Override
    public UserDto findById(int id) {
        var user = userRepo.findById(id);
        return user != null ? modelMapper.map(user, UserDto.class) : null;
    }

    @Override
    public void update(UserDto userDto) {
        if(userRepo.existsById(userDto.getId()))
            save(userDto);
    }

    @Override
    public void delete(int id) {
        var user = userRepo.findById(id).orElse(null);
        if(user != null)
            userRepo.delete(user);
    }

}
