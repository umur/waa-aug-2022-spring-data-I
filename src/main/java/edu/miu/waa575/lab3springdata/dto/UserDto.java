package edu.miu.waa575.lab3springdata.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class UserDto {
    private String email;
    private String firstName;
    private String lastName;
    List<ReviewDto> reviews;
    private AddressDto address;
}
