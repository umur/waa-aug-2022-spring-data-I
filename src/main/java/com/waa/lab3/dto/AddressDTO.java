package com.waa.lab3.dto;

import lombok.Data;

import javax.persistence.*;

@Data
public class AddressDTO {
    private int id;
    private String street;
    private int zip;
    private String city;
}
