package edu.miu.lab3.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private double price;
    private double rating;
    private CategoryDTO categoryDTO;
}
