package lab.waa.three.databasedemo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;

  private String street;
  private String zip;
  private String city;

  @OneToOne
  private User user;
}
