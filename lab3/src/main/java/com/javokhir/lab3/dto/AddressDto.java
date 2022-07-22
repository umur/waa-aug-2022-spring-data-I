package com.javokhir.lab3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    private Long id;

    private String street;

    private String zip;

    private String city;

    private UserDto user;
}
