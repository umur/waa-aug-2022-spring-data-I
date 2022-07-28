package com.miu.edu.lab3springdata.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String street;
    private String zip;
    private String city;

    @OneToOne
    private User user;
}
