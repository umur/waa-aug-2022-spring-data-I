package lab3.phase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private List<ReviewDTO> reviews;
    private AddressDTO address;
}
