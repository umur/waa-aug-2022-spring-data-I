package edu.miu.waa575.lab3springdata.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AddressDto {
    private String street;
    private String zip;
    private String city;
}
