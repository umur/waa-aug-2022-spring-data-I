package edu.miu.lab3.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double price;
    private double rating;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Category category;
}
