package com.lab3.waaaug2022springdatai.joincolumn_unidir.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String street;
    private String zip;
    private String city;
}
