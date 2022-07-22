package edu.miu.lab3.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryDTO {
    private String name;
    private List<ProductDTO> products;
}
