package lab.waa.three.databasedemo.service.impl;

import lab.waa.three.databasedemo.dto.UserDto;
import lab.waa.three.databasedemo.entity.User;
import lab.waa.three.databasedemo.mapper.UserMapper;
import lab.waa.three.databasedemo.reposoitory.UserRepository;
import lab.waa.three.databasedemo.service.UserService;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  private UserRepository userRepository;
  private UserMapper userMapper;

  public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  @Override
  public void save(UserDto userDto) {
    userRepository.save(userMapper.toModel(userDto));
  }

  @Override
  public void delete(int id) {
    userRepository.deleteById(id);
  }

  @Override
  public void update(int id, UserDto userDto) {
    userRepository.save(userMapper.toModel(userDto));
  }

  @Override
  public List<UserDto> findAll() {
    var users = new ArrayList<UserDto>();
    var data = userRepository.findAll();

    data.forEach(user -> users.add(userMapper.toDTO(user)));

    return users;
  }

  @Override
  public UserDto findById(int id) {
    return userMapper.toDTO(userRepository.findById(id).orElse(null));
  }
}
