package com.lab3.waaaug2022springdatai.joincolumn_bidir.service;

import com.lab3.waaaug2022springdatai.joincolumn_bidir.dto.ReviewDto;
import com.lab3.waaaug2022springdatai.joincolumn_bidir.dto.UserDto;
import com.lab3.waaaug2022springdatai.joincolumn_bidir.entity.User;

import java.util.List;

public interface UserService {
    User save(UserDto userDto);

    void delete(int id);

    User getById(int id);

    List<User> getAll();

    User updateUser(User user);

    ReviewDto createUserReview(ReviewDto reviewDto);
}
