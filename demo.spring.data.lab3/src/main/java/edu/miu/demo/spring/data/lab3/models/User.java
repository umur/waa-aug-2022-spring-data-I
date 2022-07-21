package edu.miu.demo.spring.data.lab3.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToOne
    @JoinColumn(name="address_id", referencedColumnName = "id")
    private Address address;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;
}
