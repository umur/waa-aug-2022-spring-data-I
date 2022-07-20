package miu.edu.lab03.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private Double rating;
    private CategoryDTO category;
}
