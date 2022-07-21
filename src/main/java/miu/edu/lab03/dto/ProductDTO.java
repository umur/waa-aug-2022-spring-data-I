package miu.edu.lab03.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private Double rating;
    @JsonIgnore
    private CategoryDTO category;
}
