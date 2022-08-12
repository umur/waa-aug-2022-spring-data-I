package com.example.waa_lab3.Domian;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<Product> products = new ArrayList<>();


    public Category(String name) {
        this.name = name;
    }


    public void addProduct(Product product) {
        products.add(product);
    }
}
