package edu.miu.lab3springdata.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToOne
    private Address address;
}
