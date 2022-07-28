package com.miu.edu.lab3springdata.dto;

import com.miu.edu.lab3springdata.entity.Product;
import com.miu.edu.lab3springdata.entity.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class ReviewDto {
    private int id;
    private String comment;

    private User user;

    private Product product;
}
