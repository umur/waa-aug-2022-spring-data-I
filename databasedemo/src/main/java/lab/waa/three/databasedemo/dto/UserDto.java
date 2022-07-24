package lab.waa.three.databasedemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "User Dto")
@Data
public class UserDto {
  private int id;

  @JsonProperty
  private String email;

  @JsonProperty
  private String password;

  @JsonProperty
  private String firstName;

  @JsonProperty
  @Schema(description = "User Id")
  private String lastName;
}
