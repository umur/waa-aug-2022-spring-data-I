package miu.edu.lab3.service.impl;

import miu.edu.lab3.dto.UserCreateDto;
import miu.edu.lab3.dto.UserDetailsDto;
import miu.edu.lab3.dto.UserDto;
import miu.edu.lab3.entity.User;
import miu.edu.lab3.repo.UserRepo;
import miu.edu.lab3.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo repository;
    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepo repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDto> getAll() {
        var entity = repository.findAll();
        List<UserDto> result = new ArrayList<>();
        entity.forEach(e-> result.add(modelMapper.map(e, UserDto.class)));
        return result;
    }

    @Override
    public UserDetailsDto getById(int id) {
        var entity = repository.findById(id);
        if(entity.isPresent()==false)
            return null;
        var result = modelMapper.map(entity.get(), UserDetailsDto.class);
        return result;
    }

    @Override
    public void save(UserCreateDto user) {
        var entity = modelMapper.map(user, User.class);
        repository.save(entity);

    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void update(int id, UserCreateDto user) throws Exception {
        var entity = modelMapper.map(user, User.class);
        var existing = repository.findById(id);

        if(existing.isPresent()==false){
            throw new Exception("Entity not found");
        }
        entity.setId(id);
        repository.save(entity);

    }
}
