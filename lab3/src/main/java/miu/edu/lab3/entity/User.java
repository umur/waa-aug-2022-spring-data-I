package miu.edu.lab3.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="table_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @JoinColumn(name = "user_id")
    @OneToMany(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    private List<Review> reviews;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address address;
}
