package lab3.phase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    @OneToMany
    private List<Review> reviews;

    @OneToOne
    private Address address;
}
