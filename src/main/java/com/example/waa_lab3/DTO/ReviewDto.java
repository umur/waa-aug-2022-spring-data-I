package com.example.waa_lab3.DTO;


import com.example.waa_lab3.Domian.User;
import lombok.Data;

@Data
public class ReviewDto {

    private int id;
    private String comment ;
    private User user ;
}
