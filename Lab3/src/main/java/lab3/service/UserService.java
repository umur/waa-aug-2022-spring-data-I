package lab3.service;

import lab3.dto.ReviewDto;
import lab3.dto.UserDto;
import lab3.entity.Review;
import lab3.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    UserDto findUserById(int id);
    UserDto createUser(UserDto userDto);
    User updateUser(User user);
    void deleteUserById(int id);
    ReviewDto createUserReview(ReviewDto reviewDto);

    List<ReviewDto> findAllReviewsByProductId(int id);
}
