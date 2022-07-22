package com.waa.lab3.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.waa.lab3.entity.Product;
import com.waa.lab3.entity.User;
import lombok.Data;

import javax.persistence.*;

@Data
public class ReviewDTO {
    private int id;
    private String comment;

    @JsonBackReference
//    @JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="id")
    private ProductDTO product;
}
