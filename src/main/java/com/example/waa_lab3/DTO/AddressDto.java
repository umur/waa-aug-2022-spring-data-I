package com.example.waa_lab3.DTO;



import com.example.waa_lab3.Domian.User;
import lombok.Data;


@Data
public class AddressDto {
    private int id;
    private String street;
    private int zip;
    private String city;


    private User user ;
}
