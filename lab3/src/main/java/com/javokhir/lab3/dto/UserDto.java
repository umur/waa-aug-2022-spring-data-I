package com.javokhir.lab3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private AddressDto address;

    private List<ReviewDto> reviews;
}
