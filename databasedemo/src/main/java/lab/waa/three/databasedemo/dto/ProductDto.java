package lab.waa.three.databasedemo.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lab.waa.three.databasedemo.entity.Category;
import lombok.Data;

import javax.persistence.*;

@Data
@Schema(description = "User Dto")
public class ProductDto {
  private int id;

  private String name;

  private double price;
  private float rating;

  private Category category;
}
