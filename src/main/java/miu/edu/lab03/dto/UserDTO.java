package miu.edu.lab03.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import miu.edu.lab03.model.Address;

@Data
public class UserDTO {
    private Long id;
    private String email;
    @JsonIgnore
    private String password;
    private String firstname;
    private String lastname;
    private Address address;
}
