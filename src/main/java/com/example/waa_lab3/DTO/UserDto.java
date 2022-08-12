package com.example.waa_lab3.DTO;

import com.example.waa_lab3.Domian.Address;
import com.example.waa_lab3.Domian.Product;
import com.example.waa_lab3.Domian.Review;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private int id;
    private String email;
    private String password;
    private String firstname;
    private String lastname ;
    private List<Product> products ;
    private List<Review> reviews;
    private List<Address> addresses ;
}
