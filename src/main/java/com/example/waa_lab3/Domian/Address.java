package com.example.waa_lab3.Domian;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue
    private int id;
    private String street;
    private int zip;
    private String city;


    @OneToOne(mappedBy = "address" )
    @JsonBackReference
    private User user;


    public Address(String street, int zip, String city) {
        this.street = street;
        this.zip = zip;
        this.city = city;

    }

}
