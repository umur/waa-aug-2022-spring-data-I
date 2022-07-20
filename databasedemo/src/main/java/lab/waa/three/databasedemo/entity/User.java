package lab.waa.three.databasedemo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "my_user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;

  private String email;

  private String password;

  private String firstName;

  private String lastName;

  @JsonBackReference
  @OneToMany(mappedBy = "user")
  List<Review> reviews;

  @OneToOne
  Address address;
}
