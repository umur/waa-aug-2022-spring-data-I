package com.waa.lab3.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class ProductDTO {
    private int id;
    private String name;
    private int price;
    private int rating;
    private CategoryDTO category;
    private List<ReviewDTO> reviews;

}
