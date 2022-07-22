package edu.miu.lab3.domain;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String name;
    private double price;
    private double rating;

    @ManyToOne
    private Category category;
}
