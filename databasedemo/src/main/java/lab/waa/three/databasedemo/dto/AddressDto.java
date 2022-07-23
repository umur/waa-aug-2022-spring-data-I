package lab.waa.three.databasedemo.dto;

import lab.waa.three.databasedemo.entity.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AddressDto {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;

  private String street;
  private String zip;
  private String city;

  @OneToOne
  private User user;
}
