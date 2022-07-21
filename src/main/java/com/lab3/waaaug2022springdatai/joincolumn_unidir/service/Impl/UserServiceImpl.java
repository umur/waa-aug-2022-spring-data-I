package com.lab3.waaaug2022springdatai.joincolumn_unidir.service.Impl;

import com.lab3.waaaug2022springdatai.joincolumn_unidir.dto.ReviewDto;
import com.lab3.waaaug2022springdatai.joincolumn_unidir.dto.UserDto;
import com.lab3.waaaug2022springdatai.joincolumn_unidir.entity.Product;
import com.lab3.waaaug2022springdatai.joincolumn_unidir.entity.Review;
import com.lab3.waaaug2022springdatai.joincolumn_unidir.entity.User;
import com.lab3.waaaug2022springdatai.joincolumn_unidir.repository.AddressRepository;
import com.lab3.waaaug2022springdatai.joincolumn_unidir.repository.ProductRepository;
import com.lab3.waaaug2022springdatai.joincolumn_unidir.repository.ReviewRepository;
import com.lab3.waaaug2022springdatai.joincolumn_unidir.repository.UserRepository;
import com.lab3.waaaug2022springdatai.joincolumn_unidir.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    @Override
    public User save(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public ReviewDto createUserReview(ReviewDto reviewDto) {
        User user = userRepository.findById(reviewDto.getUserId()).get();
        Product product = productRepository.findById(reviewDto.getProductId()).get();

        Review myReview = modelMapper.map(reviewDto, Review.class);

        myReview.setUser(user);
        myReview.setProduct(product);

        Review review = reviewRepository.save(myReview);

        return modelMapper.map(review, ReviewDto.class);
    }
}
