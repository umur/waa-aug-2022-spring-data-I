package edu.miu.lab3springdata.dto;

import lombok.Data;

@Data
public class AddressDto {
    private int id;
    private String street;
    private int zip;
    private String city;
}
