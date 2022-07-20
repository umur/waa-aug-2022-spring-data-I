package miu.edu.lab03.dto;

import lombok.Data;

@Data
public class ReviewDTO {
    private Long id;
    private String comment;
    private UserDTO user;
}
