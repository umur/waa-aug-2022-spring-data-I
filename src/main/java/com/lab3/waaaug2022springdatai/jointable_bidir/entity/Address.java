package com.lab3.waaaug2022springdatai.jointable_bidir.entity;

import com.lab3.waaaug2022springdatai.joincolumn_bidir.entity.User;
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
