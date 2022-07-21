package edu.miu.lab3.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.miu.lab3.entity.Category;


public class ProductDto {

    private int id;

    private String name;
    private double price;
    private double rating;


    @JsonBackReference
    private Category category;
}
