package lab.waa.three.databasedemo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;

  private String name;

  @JsonBackReference
  @OneToMany(mappedBy = "category")
  private List<Product> products;
}
