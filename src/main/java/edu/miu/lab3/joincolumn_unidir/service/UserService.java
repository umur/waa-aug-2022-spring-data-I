package edu.miu.lab3.joincolumn_unidir.service;

import edu.miu.lab3.joincolumn_unidir.dto.ReviewDto;
import edu.miu.lab3.joincolumn_unidir.dto.UserDto;
import edu.miu.lab3.joincolumn_unidir.entity.User;

import java.util.List;

public interface UserService {
    User save(UserDto userDto);

    void delete(int id);

    User getById(int id);

    List<User> getAll();

    User updateUser(User user);

    ReviewDto createUserReview(ReviewDto reviewDto);
}
