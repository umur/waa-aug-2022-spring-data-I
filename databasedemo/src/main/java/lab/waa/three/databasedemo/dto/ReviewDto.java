package lab.waa.three.databasedemo.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lab.waa.three.databasedemo.entity.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Schema(description = "User Dto")
public class ReviewDto {
  private int id;
  private String comment;

  private int userId;

}
