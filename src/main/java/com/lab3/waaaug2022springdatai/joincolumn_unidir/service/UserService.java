package com.lab3.waaaug2022springdatai.joincolumn_unidir.service;

import com.lab3.waaaug2022springdatai.joincolumn_unidir.dto.ReviewDto;
import com.lab3.waaaug2022springdatai.joincolumn_unidir.dto.UserDto;
import com.lab3.waaaug2022springdatai.joincolumn_unidir.entity.User;

import java.util.List;

public interface UserService {
    User save(UserDto userDto);

    void delete(int id);

    User getById(int id);

    List<User> getAll();

    User updateUser(User user);

    ReviewDto createUserReview(ReviewDto reviewDto);
}
