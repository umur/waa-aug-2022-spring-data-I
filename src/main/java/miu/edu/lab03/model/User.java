package miu.edu.lab03.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name="user_table")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
