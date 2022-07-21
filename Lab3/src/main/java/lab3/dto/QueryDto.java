package lab3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryDto {
    double minPrice;
    double maxPrice;
    String category;
    String keyword;
}
