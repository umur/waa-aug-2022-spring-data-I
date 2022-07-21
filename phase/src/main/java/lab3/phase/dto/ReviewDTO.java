package lab3.phase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    private int id;
    private String comment;
    private UserDTO user;
}
