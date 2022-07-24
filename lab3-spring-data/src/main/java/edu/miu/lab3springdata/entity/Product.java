package edu.miu.lab3springdata.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private float price;
    private int rating;

    @ManyToOne
    private Category category;

}
