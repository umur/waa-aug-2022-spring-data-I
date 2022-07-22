package edu.miu.lab3.dto;

import lombok.Data;

@Data
public class ReviewDTO {
    private String comment;
    private UserDTO userDTO;
}
