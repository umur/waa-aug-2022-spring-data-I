package edu.miu.waa575.lab3springdata.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class ProductDto {
    private String name;
    private float price;
    private float rating;

    private List<ReviewDto> reviews;
}
