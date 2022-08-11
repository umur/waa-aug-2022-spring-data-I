package miu.edu.lab3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.lab3.entity.Category;

import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailsDto {
    private int id;
    private String name;
    private float price;
    private float rating;
    private CategoryDto category;
}
