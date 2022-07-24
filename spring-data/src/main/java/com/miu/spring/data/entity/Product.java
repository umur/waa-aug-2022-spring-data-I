package com.miu.spring.data.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double price;
    private int rating;
    @ManyToOne
    private Category category;

}
