package com.example.waa_lab3.DTO;


import lombok.Data;

@Data
public class ProductDto {

    private int id;
    private String name;
    private double price;
    private double rating;

    private CategoryDto category;
}
