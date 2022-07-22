package edu.miu.lab3.service;

import edu.miu.lab3.domain.User;
import edu.miu.lab3.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();
    User addUser(UserDTO userDTO);
    UserDTO findById(int id);
    User update(User user);
    UserDTO deleteById(int id);
}
