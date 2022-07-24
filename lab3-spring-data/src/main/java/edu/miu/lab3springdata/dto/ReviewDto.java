package edu.miu.lab3springdata.dto;

import lombok.Data;
@Data
public class ReviewDto {
    private int id;
    private String comment;

    private UserDto user;
}
