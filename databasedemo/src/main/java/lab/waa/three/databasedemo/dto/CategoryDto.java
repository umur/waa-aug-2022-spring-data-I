package lab.waa.three.databasedemo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lab.waa.three.databasedemo.entity.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class CategoryDto {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;

  private String name;

  @JsonBackReference
  @OneToMany(mappedBy = "category")
  private List<Product> products;
}
