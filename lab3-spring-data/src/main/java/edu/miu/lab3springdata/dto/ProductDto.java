package edu.miu.lab3springdata.dto;

import lombok.Data;

@Data
public class ProductDto {
    private int id;
    private String name;
    private float price;
    private int rating;

    private CategoryDto category;
}
