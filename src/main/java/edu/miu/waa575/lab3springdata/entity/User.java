package edu.miu.waa575.lab3springdata.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    @JsonIgnore
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    List<Review> reviews;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}