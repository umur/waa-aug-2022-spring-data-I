package lab.waa.three.databasedemo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lab.waa.three.databasedemo.entity.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Schema(description = "User Dto")
public class CategoryDto {
  private int id;

  private String name;
  private List<Product> products;
}
