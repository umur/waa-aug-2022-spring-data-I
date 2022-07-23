package miu.edu.lab03.dto;

import lombok.Data;
import miu.edu.lab03.model.User;

@Data
public class AddressDTO {
    private Long id;
    private String street;
    private String zip;
    private String city;
    private User user;
}
