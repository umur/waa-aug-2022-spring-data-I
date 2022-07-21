package com.javokhir.lab3.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(columnDefinition = "NUMERIC(5,2)")
    private Double price;

    @Column(columnDefinition = "NUMERIC(5,1)")
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
