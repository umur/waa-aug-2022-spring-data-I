package edu.miu.lab3.service.impl;

import edu.miu.lab3.domain.User;
import edu.miu.lab3.dto.UserDTO;
import edu.miu.lab3.repository.UserRepository;
import edu.miu.lab3.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {

    UserRepository userRepository;

    ModelMapper modelMapper;

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                     .map(user -> modelMapper.map(user, UserDTO.class))
                     .collect(Collectors.toList());
    }


    @Override
    public User addUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        userRepository.save(user);
        return  user;
    }

    @Override
    public UserDTO findById(int id) {
        Optional<User> user = userRepository.findById(id);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public User update(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public UserDTO deleteById(int id) {
       Optional<User> user = userRepository.findById(id);
       userRepository.deleteById(id);
      return  modelMapper.map(user, UserDTO.class);
    }
}
