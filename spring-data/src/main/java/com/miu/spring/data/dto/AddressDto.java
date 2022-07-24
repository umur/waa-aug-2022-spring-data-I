package com.miu.spring.data.dto;

import com.miu.spring.data.entity.User;

import javax.persistence.*;


public class AddressDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String street;
    private int zip;
    private String city;
    private String state;
    private User user;

}
