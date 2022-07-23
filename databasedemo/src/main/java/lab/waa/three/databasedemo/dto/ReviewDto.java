package lab.waa.three.databasedemo.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lab.waa.three.databasedemo.entity.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ReviewDto {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;
  private String comment;

  @JsonManagedReference
  @ManyToOne
  private User user;
}
