package lab3.phase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private int id;
    private String street;
    private String zip;
    private String city;
    private UserDTO user;
}
