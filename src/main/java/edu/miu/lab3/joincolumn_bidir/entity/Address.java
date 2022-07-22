package edu.miu.lab3.joincolumn_bidir.entity;

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

    @OneToOne(mappedBy = "address")
    private User user;
}
