package edu.miu.lab3.joincolumn_unidir.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AddressDto {

    private String street;
    private String zip;
    private String city;
}
