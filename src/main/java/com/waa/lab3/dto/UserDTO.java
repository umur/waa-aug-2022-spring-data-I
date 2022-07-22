package com.waa.lab3.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class UserDTO {
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private AddressDTO address;
}
