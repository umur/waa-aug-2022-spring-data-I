package com.lab3.waaaug2022springdatai.joincolumn_bidir.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AddressDto {

    private String street;
    private String zip;
    private String city;
}
