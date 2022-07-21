package edu.miu.lab3.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.miu.lab3.entity.Product;

import java.util.List;

public class CategoryDto {

    private int id;

    private String name;

    @JsonManagedReference
    private List<Product> products;
}
