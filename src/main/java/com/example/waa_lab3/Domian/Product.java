package com.example.waa_lab3.Domian;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private  double price;
    private double rating;

    @ManyToOne
    @JsonManagedReference
    private Category category;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<Review> reviews;

//    public Product(String name, double price, double rating) {
//        this.name = name;
//        this.price = price;
//        this.rating = rating;
//    }


    public void addReview(Review review) {
        reviews.add(review);
    }

}
