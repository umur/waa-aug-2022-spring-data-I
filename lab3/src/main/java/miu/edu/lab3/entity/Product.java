package miu.edu.lab3.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private float price;
    private float rating;

    @ManyToOne
    private Category category;
}
