package lab.waa.three.databasedemo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;

  private String name;

  private double price;
  private float rating;

  @JsonManagedReference
  @ManyToOne
  private Category category;
}
