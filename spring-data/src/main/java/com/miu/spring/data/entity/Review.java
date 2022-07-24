package com.miu.spring.data.entity;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String comment;
    @ManyToOne
   private User user;
}
