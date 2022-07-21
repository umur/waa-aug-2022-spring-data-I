package lab3.controller;

import com.example.lab3.dto.ProductDto;
import com.example.lab3.dto.ReviewDto;
import com.example.lab3.dto.UserDto;
import com.example.lab3.entity.Review;
import com.example.lab3.entity.User;
import com.example.lab3.service.UserService;
import com.example.lab3.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    @Qualifier("userService1")
    private UserService userService;

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @PostMapping("/user")
    public UserDto createUser(@RequestBody UserDto userDto){

        System.out.println(userDto.toString());
        return userService.createUser(userDto);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id) throws Exception {
        userService.deleteUserById(id);
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user) throws Exception {
        return userService.updateUser(user);
    }

    @PostMapping("/user/review")
    public ReviewDto createReview(@RequestBody ReviewDto reviewDto){
        return userService.createUserReview(reviewDto);
    }
    @GetMapping("/reviews/{id}")
    public List<ReviewDto> findAllReviewsByProductId(@PathVariable(name = "id") int productId){
        return userService.findAllReviewsByProductId(productId);
    }
}
