package edu.miu.lab3.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.miu.lab3.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private int id;

    private String name;
    private double price;
    private double rating;


    @JsonBackReference
    private Category category;
}
