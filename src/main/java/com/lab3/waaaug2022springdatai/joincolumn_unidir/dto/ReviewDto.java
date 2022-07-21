package com.lab3.waaaug2022springdatai.joincolumn_unidir.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private int id;
    private int productId;
    private int userId;
}
