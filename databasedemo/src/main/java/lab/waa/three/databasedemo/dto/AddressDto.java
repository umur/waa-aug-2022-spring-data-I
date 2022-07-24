package lab.waa.three.databasedemo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lab.waa.three.databasedemo.entity.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Schema(description = "User Dto")
public class AddressDto {
  private int id;

  private String street;
  private String zip;
  private String city;

  private User user;
}
