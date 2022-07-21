package com.lab3.waaaug2022springdatai.joincolumn_unidir.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String name;
    private double price;
    private double rating;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
