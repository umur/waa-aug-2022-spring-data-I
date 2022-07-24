package com.miu.spring.data.dto;

import com.miu.spring.data.entity.Category;
import lombok.Data;


@Data
public class ProductDto {
    private int id;
    private String name;
    private double price;
    private int rating;
    private CategoryDto category;

}
