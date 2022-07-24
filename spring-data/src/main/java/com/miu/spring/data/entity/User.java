package com.miu.spring.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String lName;
    private String email;
    private String fName;
    @JsonIgnore
    private String password;
    @OneToMany
    private List<Review> reviews;
    @OneToOne
    private Address address;


}
