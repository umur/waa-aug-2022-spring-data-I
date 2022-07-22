package edu.miu.waa575.lab3springdata.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String zip;
    private String city;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private User user;
}
