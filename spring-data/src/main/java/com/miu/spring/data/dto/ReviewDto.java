package com.miu.spring.data.dto;

import com.miu.spring.data.entity.Category;
import com.miu.spring.data.entity.User;


public class ReviewDto {
    private int id;
    private String name;
    private double price;
    private int rating;

    private UserDto userDto;
}
