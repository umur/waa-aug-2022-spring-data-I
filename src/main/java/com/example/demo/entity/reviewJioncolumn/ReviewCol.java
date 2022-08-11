package com.example.demo.entity.reviewJioncolumn;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ReviewCol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String comment;
    @ManyToOne
    private UserCol userCol;
}
