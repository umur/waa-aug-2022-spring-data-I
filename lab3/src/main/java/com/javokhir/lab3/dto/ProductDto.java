package com.javokhir.lab3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {


    private Long id;

    private String name;

    private Double price;

    private Double rating;

    private CategoryDto category;

    private List<ReviewDto> reviews = new ArrayList<>();
}
