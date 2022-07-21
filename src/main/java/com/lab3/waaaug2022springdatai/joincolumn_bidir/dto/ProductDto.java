package com.lab3.waaaug2022springdatai.joincolumn_bidir.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductDto {

    private String name;
    private double price;
    private double rating;
    private int categoryId;
}
