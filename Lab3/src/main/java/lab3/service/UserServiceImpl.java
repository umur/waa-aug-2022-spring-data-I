package lab3.service;

import lab3.dto.ReviewDto;
import lab3.dto.UserDto;
import lab3.entity.Product;
import lab3.entity.Review;
import lab3.entity.User;
import lab3.repository.ProductRepo;
import lab3.repository.ReviewRepo;
import lab3.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("userService1")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ReviewRepo reviewRepo;
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<User> findAllUsers() {
        return (List<User>) userRepo.findAll();
    }

    public UserDto findUserById(int id) {
        User usr = userRepo.findById(id).get();
        UserDto resDto = modelMapper.map(usr, UserDto.class);
        return resDto;
    }

    public UserDto createUser(UserDto userDto) {
        User myUser = modelMapper.map(userDto, User.class);
        User user = userRepo.save(myUser);
        UserDto userDto1 = modelMapper.map(user, UserDto.class);
        return userDto1;
    }

    public User updateUser(User user){
        return userRepo.save(user);
    }

    public void deleteUserById(int id){
        userRepo.deleteById(id);
    }

    public ReviewDto createUserReview(ReviewDto reviewDto) {
        User user = userRepo.findById(reviewDto.getUserId()).get();
        Product product = productRepo.findById(reviewDto.getProductId()).get();

        Review myReview = modelMapper.map(reviewDto, Review.class);

        myReview.setUser(user);
        myReview.setProduct(product);

        Review review = reviewRepo.save(myReview);

        return modelMapper.map(review, ReviewDto.class);
    }

    @Override
    public List<ReviewDto> findAllReviewsByProductId(int id) {
        List<Review> reviews = reviewRepo.findAllByProduct_Id(id);
        List<ReviewDto> reviewDtos = new ArrayList<>();

        for(Review review: reviews) {
            ReviewDto reviewDto = modelMapper.map(review, ReviewDto.class);
            reviewDto.setUserId(review.getUser().getId());
            reviewDto.setProductId(review.getProduct().getId());
            reviewDtos.add(reviewDto);
        }
        return reviewDtos;
    }

}
