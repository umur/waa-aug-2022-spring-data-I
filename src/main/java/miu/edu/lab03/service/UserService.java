package miu.edu.lab03.service;

import miu.edu.lab03.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();
    Optional<User> getById(Long id);
    User save(User user);
    void delete(Long id);
}
