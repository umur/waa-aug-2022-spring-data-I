package miu.edu.lab03.dto;

import lombok.Data;
import miu.edu.lab03.model.Address;

import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private Address address;
    private List<ReviewDTO> reviews;
}
