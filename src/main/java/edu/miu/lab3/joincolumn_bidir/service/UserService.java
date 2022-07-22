package edu.miu.lab3.joincolumn_bidir.service;

import edu.miu.lab3.joincolumn_bidir.dto.ReviewDto;
import edu.miu.lab3.joincolumn_bidir.dto.UserDto;
import edu.miu.lab3.joincolumn_bidir.entity.User;

import java.util.List;

public interface UserService {
    User save(UserDto userDto);

    void delete(int id);

    User getById(int id);

    List<User> getAll();

    User updateUser(User user);

    ReviewDto createUserReview(ReviewDto reviewDto);
}
