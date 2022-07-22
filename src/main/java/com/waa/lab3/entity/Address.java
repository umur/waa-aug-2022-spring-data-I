package com.waa.lab3.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String street;
    private int zip;
    private String city;

    @OneToOne(mappedBy = "address")
    private User user;
}
