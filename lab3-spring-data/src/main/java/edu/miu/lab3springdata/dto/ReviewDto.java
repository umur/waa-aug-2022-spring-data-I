package edu.miu.lab3springdata.dto;

import edu.miu.lab3springdata.entity.Product;
import lombok.Data;
@Data
public class ReviewDto {
    private int id;
    private String comment;

    private UserDto user;
    private ProductDto product;
}
