package lab.waa.three.databasedemo.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lab.waa.three.databasedemo.entity.Category;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ProductDto {
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
