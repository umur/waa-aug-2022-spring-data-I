package miu.edu.lab3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.lab3.entity.Address;
import miu.edu.lab3.entity.Review;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {
    private String email;
    private String password;
    private String firstname;
    private String lastname;

    private List<ReviewDto> reviews;

    private AddressDto address;
}
