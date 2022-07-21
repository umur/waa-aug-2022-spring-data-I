package lab3.entity;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user; // reviewer

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

}