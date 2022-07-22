package bekmax.springdata1.dto;

import bekmax.springdata1.model.Review;
import bekmax.springdata1.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private Long id;
    private String comment;
    private Long userId;
    private Long productId;
}
