package com.example.springdatademo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private float rating;
    private double price;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;
}
